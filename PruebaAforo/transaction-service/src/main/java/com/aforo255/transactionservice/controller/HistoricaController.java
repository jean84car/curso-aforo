package com.aforo255.transactionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.transactionservice.model.Transaction;
import com.aforo255.transactionservice.service.ITransactionService;

@RestController
public class HistoricaController {

	@Autowired
	private ITransactionService transaction;
	
	@GetMapping("/transaction/{accountId}")
	public ResponseEntity<?> obtenerByAccountId (@PathVariable Integer accountId){
		
		Iterable<Transaction> iTransaction=transaction.buscarXfacturaId(accountId);
		
		return ResponseEntity.ok(iTransaction);
		
	}
	
	
	@GetMapping("/listar")
	public List<Transaction> listar(){
		
		return (List<Transaction>) transaction.listar();
	}
	
	
}
