package com.quispesucso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quispesucso.entity.Sala;
import com.quispesucso.repository.SalaRepository;

@Service
public class SalaServiceImp implements SalaService 
{
	@Autowired
	private SalaRepository repository;

	@Override
	@Transactional
	public void insert(Sala sala) {
		repository.save(sala);
	}

	@Override
	@Transactional
	public void update(Sala sala) {
		repository.save(sala);
	}

	@Override
	@Transactional
	public void delete(Integer salaId) {
		repository.deleteById(salaId);
	}

	@Override
	@Transactional(readOnly = true)
	public Sala findById(Integer salaId) {
		return repository.findById(salaId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Sala> findAll() {
		return repository.findAll();
	}
	
}
