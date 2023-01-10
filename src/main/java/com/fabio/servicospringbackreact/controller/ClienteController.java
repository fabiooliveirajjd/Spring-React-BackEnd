package com.fabio.servicospringbackreact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.servicospringbackreact.entidade.Cliente;
import com.fabio.servicospringbackreact.entidade.RespostaCliente;
import com.fabio.servicospringbackreact.services.ClienteServices;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	private ClienteServices clienteServices;

	@GetMapping("/listar")
	public Iterable<Cliente> listar() {
		return clienteServices.listar();
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
		return clienteServices.cadastrarAlterar(cliente, "cadastrar");
	}

	@PutMapping("/alterar")
	public ResponseEntity<?> alterar(@RequestBody Cliente cliente) {
		return clienteServices.cadastrarAlterar(cliente, "alterar");
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<RespostaCliente> remover(@PathVariable Integer id) {
		return clienteServices.remover(id);
	}

}
