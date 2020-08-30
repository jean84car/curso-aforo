package com.aforo255.invocesservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aforo255.invocesservice.model.Factura;

public interface IFacturaRepository extends CrudRepository<Factura, Long> {

	@Query("select f from Factura f where f.cliente.id = ?1")
	public List<Factura> consultarFacturasCliente(Long idCliente);
	
	@Query("select f from Factura f where f.cliente.id = ?1 and f.id = ?2 ")
	public Factura consultarFacturasCliente(Long idCliente, Long idFactura);
	
}
