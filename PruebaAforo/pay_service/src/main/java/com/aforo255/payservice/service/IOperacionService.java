package com.aforo255.payservice.service;

import com.aforo255.payservice.model.Factura;

public interface IOperacionService {

	public Factura pagarFactura(Factura factura) throws Exception;
	
}
