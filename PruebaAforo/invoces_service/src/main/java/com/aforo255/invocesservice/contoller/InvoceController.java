package com.aforo255.invocesservice.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.invocesservice.model.Factura;
import com.aforo255.invocesservice.service.IInvoceService;

@RestController
public class InvoceController {

	private static final Logger log = LoggerFactory.getLogger(InvoceController.class);
	
	@Autowired
	private IInvoceService invoceService;
	
	@GetMapping
	public List<Factura> consultarFacturas() {
		log.info("INVOCE :: INICIO :: consultarFacturas");
		return invoceService.consultarFacturas();
	}
	
	@GetMapping("/{id}")
	public List<Factura> consultarFacturasCliente(@PathVariable(name = "id") Long idCliente) {
		log.info(String.format("INVOCE :: INICIO :: consultarFacturasCliente :: Cliente: %d", idCliente));
		return invoceService.consultarFacturasCliente(idCliente);
	}
	
	@PutMapping
	public Factura pagarFactura(@RequestBody Factura factura) throws Exception {
		log.info(String.format("INVOCE :: INICIO :: pagarFactura :: factura: %d", factura.getId()));
		return invoceService.pagarFactura(factura);
	}
	
}
