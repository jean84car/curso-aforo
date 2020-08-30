package com.aforo255.transactionservice.service;

import com.aforo255.transactionservice.model.Transaction;

public interface ITransactionService {

	public Transaction save(Transaction transaction);
	
	public Iterable<Transaction> buscarXfacturaId(Integer accountId);
	
	public Iterable<Transaction>  listar();
	
}
