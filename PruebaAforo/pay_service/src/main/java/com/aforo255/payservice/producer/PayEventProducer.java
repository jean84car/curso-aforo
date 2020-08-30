package com.aforo255.payservice.producer;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.aforo255.payservice.dto.TransactionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PayEventProducer {
	private static final Logger log = LoggerFactory.getLogger(PayEventProducer.class);

	public static final String TOPIC = "transaction-events";
	
	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	public ListenableFuture<SendResult<Integer, String>> sendDepositEvent (TransactionDTO depositEvent) throws JsonProcessingException {
		log.info("PAY :: INICIO :: sendDepositEvent");
		
		Integer key = depositEvent.getIdInvoce().intValue();
		String value = objectMapper.writeValueAsString(depositEvent);
		
		ProducerRecord<Integer, String> producerRecord= buildProducerRecord(key, value, TOPIC);
		
		ListenableFuture<SendResult<Integer, String>> listenableFuture=kafkaTemplate.send(producerRecord);
		
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				try {
					handleSuccess(key,value,result);
				} catch (Exception e) {
					log.error("DEPOSIT :: ERROR :: ", e);
				}
			}

			@Override
			public void onFailure(Throwable ex) {
				handleFailure(key,value,ex);
				
			}
		} );
		
		log.info("PAY :: FIN :: sendDepositEvent");
		return listenableFuture;
	}
	
	private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {
		List<Header> recordHeader = new ArrayList<>();
		recordHeader.add(new RecordHeader("deposit-event-source", "scanner".getBytes()));
		
		return new ProducerRecord<>(topic,null,key , value, recordHeader);
	}
	
	private void handleFailure (Integer keym, String value, Throwable ex) {
		log.error("Error enviando mensaje kafka", ex);
		try {
			throw ex;
		}catch(Throwable e) {
			log.error("Error ", e);
		}
	}
	
	private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) throws JsonMappingException, JsonProcessingException {
		log.info(String.format("Mensaje enviado exitosamente :: value: %s partition:  ", value, result.getRecordMetadata().partition()));
	}
}
