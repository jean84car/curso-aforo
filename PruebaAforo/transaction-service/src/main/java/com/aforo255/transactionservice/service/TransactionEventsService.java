package com.aforo255.transactionservice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.transactionservice.model.Transaction;
import com.aforo255.transactionservice.repository.ITransactionRespository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionEventsService {

	private static final Logger log = LoggerFactory.getLogger(TransactionEventsService.class);
		
	@Autowired
	private ITransactionRespository transactionRespository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		log.info("HISTORICAL :: INICIO :: processTransactionEvent");
		
		Transaction transactionEvent = objectMapper.readValue(consumerRecord.value(), Transaction.class);		
		transactionRespository.save(transactionEvent);
		
		log.info("HISTORICAL :: FIN :: processTransactionEvent");
	}
	
}
