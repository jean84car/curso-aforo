package com.aforo255.payservice.dto;

import java.io.Serializable;


public class TransactionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id; 
		
	private Long idInvoce;
	
	private double amount;
	
	private String creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdInvoce() {
		return idInvoce;
	}

	public void setIdInvoce(Long idInvoce) {
		this.idInvoce = idInvoce;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
