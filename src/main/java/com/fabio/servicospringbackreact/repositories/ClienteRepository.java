package com.fabio.servicospringbackreact.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabio.servicospringbackreact.entidade.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer > {

}
