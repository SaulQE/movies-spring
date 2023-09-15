package com.quispesucso.service;

import java.util.Collection;

import com.quispesucso.entity.Cliente;

public interface ClienteService 
{
	//Servicios
	public abstract void insert(Cliente cliente);
	public abstract void update(Cliente cliente);
	public abstract void delete(Integer clienteId);
	public abstract Cliente findById(Integer clienteId);
	public abstract Collection<Cliente> findAll();
}
