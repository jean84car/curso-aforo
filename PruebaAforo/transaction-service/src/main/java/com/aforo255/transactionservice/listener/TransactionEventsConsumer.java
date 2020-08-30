package com.aforo255.transactionservice.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.aforo255.transactionservice.service.TransactionEventsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class TransactionEventsConsumer {
	
	private static final Logger log = LoggerFactory.getLogger(TransactionEventsConsumer.class);
	
	@Autowired
	private TransactionEventsService transactionService;
	
	@KafkaListener(topics = {"transaction-events"})
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		log.info(String.format("HISTORICAL :: INICIO :: TransactionEventsConsumer :: ConsumerRecord :: %S", consumerRecord.value()));
		
		transactionService.processTransactionEvent(consumerRecord);
		
		log.info("HISTORICAL :: FIN :: TransactionEventsConsumer :: ConsumerRecord");
	}

}
