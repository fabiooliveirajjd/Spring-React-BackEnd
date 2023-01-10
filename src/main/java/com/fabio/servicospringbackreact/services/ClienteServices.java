package com.fabio.servicospringbackreact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fabio.servicospringbackreact.entidade.Cliente;
import com.fabio.servicospringbackreact.entidade.RespostaCliente;
import com.fabio.servicospringbackreact.repositories.ClienteRepository;

@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private RespostaCliente respostaCliente;

	public Iterable<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public ResponseEntity<?> cadastrarAlterar(Cliente cliente, String acao) {

		if (cliente.getNome().equals("")) {
			respostaCliente.setMensagem("O nome é obrigatório");
			return new ResponseEntity<RespostaCliente>(respostaCliente, HttpStatus.BAD_REQUEST);
		} else if (cliente.getCpf().equals("")) {
			respostaCliente.setMensagem("O cpf é obrigatório");
			return new ResponseEntity<RespostaCliente>(respostaCliente, HttpStatus.BAD_REQUEST);
		} else if (cliente.getEmail().equals("")) {
			respostaCliente.setMensagem("O email é obrigatório");
			return new ResponseEntity<RespostaCliente>(respostaCliente, HttpStatus.BAD_REQUEST);
		} else if (cliente.getSenha().equals("")) {
			respostaCliente.setMensagem("A senha é obrigatória");
			return new ResponseEntity<RespostaCliente>(respostaCliente, HttpStatus.BAD_REQUEST);
		} else {
			if (acao.equals("cadastrar")) {
				return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.OK);
			}
		}
	}

	public ResponseEntity<RespostaCliente> remover(Integer id) {
		clienteRepository.deleteById(id);

		respostaCliente.setMensagem("Cliente deletado com sucesso!");
		return new ResponseEntity<RespostaCliente>(respostaCliente, HttpStatus.OK);
	}

}
