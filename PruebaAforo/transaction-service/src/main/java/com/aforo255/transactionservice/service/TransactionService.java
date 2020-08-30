package com.aforo255.transactionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.transactionservice.model.Transaction;
import com.aforo255.transactionservice.repository.ITransactionRespository;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private ITransactionRespository transactionRepository;
	
	@Override
	public Transaction save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Iterable<Transaction> buscarXfacturaId(Integer accountId) {
		return transactionRepository.buscarXfacturaId(accountId);
	}

	@Override
	public Iterable<Transaction> listar() {
		return transactionRepository.findAll();
	}

}
