package com.quispesucso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quispesucso.entity.Boleto;
import com.quispesucso.repository.BoletoRepository;

@Service
public class BoletoServiceImp implements BoletoService
{
	@Autowired
	private BoletoRepository repository;

	@Override
	@Transactional
	public void insert(Boleto boleto) {
		repository.save(boleto);
	}

	@Override
	@Transactional
	public void update(Boleto boleto) {
		repository.save(boleto);
	}

	@Override
	@Transactional
	public void delete(Integer boletoId) {
		repository.deleteById(boletoId);
	}

	@Override
	@Transactional(readOnly = true)
	public Boleto findById(Integer boletoId) {
		return repository.findById(boletoId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Boleto> findAll() {
		return repository.findAll();
	}
	
	
}
