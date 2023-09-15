package com.quispesucso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quispesucso.entity.Sucursal;
import com.quispesucso.repository.SucursalRepository;

@Service
public class SucursalServiceImp implements SucursalService 
{
	@Autowired
	private SucursalRepository repository;
	
	@Override
	@Transactional
	public void insert(Sucursal sucursal) {
		repository.save(sucursal);
	}

	@Override
	@Transactional
	public void update(Sucursal sucursal) {
		repository.save(sucursal);
	}

	@Override
	@Transactional
	public void delete(Integer sucursalId) {
		repository.deleteById(sucursalId);
	}

	@Override
	@Transactional(readOnly = true)
	public Sucursal findById(Integer sucursalId) {
		return repository.findById(sucursalId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Sucursal> findAll() {
		return repository.findAll();
	}

}
