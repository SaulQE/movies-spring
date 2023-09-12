package com.quispesucso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quispesucso.entity.Portada;
import com.quispesucso.repository.PortadaRepository;

@Service
public class PortadaServiceImp implements PortadaService 
{
	@Autowired
	private PortadaRepository repository;
	
	@Override
	@Transactional
	public void insert(Portada portada) {
		repository.save(portada);
	}

	@Override
	@Transactional
	public void update(Portada portada) {
		repository.save(portada);
	}

	@Override
	@Transactional
	public void delete(Integer portadaId) {
		repository.deleteById(portadaId);
	}

	@Override
	@Transactional(readOnly = true)
	public Portada findById(Integer portadaId) {
		return repository.findById(portadaId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Portada> findAll() {
		return repository.findAll();
	}

}
