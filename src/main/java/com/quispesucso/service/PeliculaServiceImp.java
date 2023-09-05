package com.quispesucso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quispesucso.entity.Pelicula;
import com.quispesucso.repository.PeliculaRepository;

@Service
public class PeliculaServiceImp implements PeliculaService 
{

	@Autowired
	private PeliculaRepository repository; // springData = repository
	
	@Override
	@Transactional
	public void insert(Pelicula pelicula) {
		repository.save(pelicula);
	}

	@Override
	@Transactional
	public void update(Pelicula pelicula) {
		repository.save(pelicula);
	}

	@Override
	@Transactional
	public void delete(Integer peliculaId) {
		repository.deleteById(peliculaId);
	}

	@Override
	@Transactional
	public Pelicula findById(Integer peliculaId) {
		return repository.findById(peliculaId).orElse(null);
	}

	@Override
	@Transactional
	public Collection<Pelicula> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Integer sumMinutos() {

		return repository.sumMinutos();
	}

}
