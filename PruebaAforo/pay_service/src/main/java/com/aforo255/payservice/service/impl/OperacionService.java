package com.aforo255.payservice.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aforo255.payservice.client.IInvoceClient;
import com.aforo255.payservice.dto.TransactionDTO;
import com.aforo255.payservice.model.Factura;
import com.aforo255.payservice.model.Operacion;
import com.aforo255.payservice.producer.PayEventProducer;
import com.aforo255.payservice.repository.IOperacionRepository;
import com.aforo255.payservice.service.IOperacionService;

@Service
@Transactional
public class OperacionService implements IOperacionService {

	@Autowired
	private IOperacionRepository facturaRepository;
	
	@Autowired
	private IInvoceClient invoceClient;
	
	@Autowired
	private PayEventProducer payProducer;
	
	@Override
	public Factura pagarFactura(Factura factura) throws Exception {
		Factura fact = invoceClient.pagarFactura(factura);
		Operacion operacion = new Operacion();
		operacion.setAmount(fact.getAmount());
		operacion.setIdInvoce(factura.getId());
		facturaRepository.save(operacion);
		
		TransactionDTO transaccion = new TransactionDTO();
		transaccion.setAmount(factura.getAmount().doubleValue());
		SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
		transaccion.setCreationDate(format.format(new Date()));
		transaccion.setIdInvoce(factura.getId());
		payProducer.sendDepositEvent(transaccion);
		
		return fact;
	}
	
}
