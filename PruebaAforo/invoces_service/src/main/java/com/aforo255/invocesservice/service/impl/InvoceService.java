package com.aforo255.invocesservice.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.invocesservice.contans.EstadoFacturaEnum;
import com.aforo255.invocesservice.model.Factura;
import com.aforo255.invocesservice.repository.IFacturaRepository;
import com.aforo255.invocesservice.service.IInvoceService;

@Service
public class InvoceService implements IInvoceService {

	private static final Logger log = LoggerFactory.getLogger(InvoceService.class);
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Override
	public List<Factura> consultarFacturas() {
		log.info("INVOCE :: INICIO :: consultarFacturas");
		return (List<Factura>) facturaRepository.findAll();
	}

	@Override
	public List<Factura> consultarFacturasCliente(Long idCliente) {
		log.info(String.format("INVOCE :: INICIO :: consultarFacturasCliente :: Cliente: %d", idCliente));
		return facturaRepository.consultarFacturasCliente(idCliente);
	}

	@Override
	public Factura pagarFactura(Factura factura) throws Exception {
		Factura fact = facturaRepository.consultarFacturasCliente(factura.getCliente().getId(), factura.getId());
		
		if(fact == null) {
			throw new Exception(String.format("Factura %d no encontrada para el cliente %d", 
				factura.getCliente().getId(), factura.getId()));
		}
		
		fact.setEstado(EstadoFacturaEnum.PAGADA.toString());
		facturaRepository.save(fact);
		
		return fact;
	}

}
