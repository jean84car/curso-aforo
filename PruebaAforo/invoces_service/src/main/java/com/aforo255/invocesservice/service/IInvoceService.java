package com.aforo255.invocesservice.service;

import java.util.List;

import com.aforo255.invocesservice.model.Factura;

public interface IInvoceService {

	public List<Factura> consultarFacturas();
	
	public List<Factura> consultarFacturasCliente(Long idCliente);
	
	public Factura pagarFactura(Factura factura) throws Exception;
	
}
