package com.aforo255.payservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aforo255.payservice.model.Factura;

@FeignClient(name = "invoces-service")
public interface IInvoceClient {

	@PutMapping
	public Factura pagarFactura(@RequestBody Factura factura) throws Exception;
	
}
