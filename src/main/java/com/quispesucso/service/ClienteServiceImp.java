package com.quispesucso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quispesucso.entity.Cliente;
import com.quispesucso.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService 
{
	@Autowired
	private ClienteRepository repository;

	@Override
	@Transactional
	public void insert(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Integer clienteId) {
		repository.deleteById(clienteId);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Integer clienteId) {
		return repository.findById(clienteId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cliente> findAll() {
		return repository.findAll();
	}

}
