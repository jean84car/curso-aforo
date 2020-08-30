package com.aforo255.invocesservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.aforo255.invocesservice.model.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}
