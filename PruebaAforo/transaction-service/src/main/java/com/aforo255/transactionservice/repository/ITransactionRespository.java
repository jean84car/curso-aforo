package com.aforo255.transactionservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.aforo255.transactionservice.model.Transaction;


public interface ITransactionRespository extends MongoRepository<Transaction, String> {

	@Query("{'idInvoce':?1}")
	public Iterable<Transaction> buscarXfacturaId(Integer id);
	
}
