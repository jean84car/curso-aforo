package com.aforo255.payservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.payservice.model.Factura;
import com.aforo255.payservice.service.IOperacionService;

@RestController
public class PayController {

	@Autowired
	private IOperacionService operacionService;
	
	@PutMapping
	public Factura pagarFactura(@RequestBody Factura factura) throws Exception {
		return operacionService.pagarFactura(factura);
	} 
	
}
