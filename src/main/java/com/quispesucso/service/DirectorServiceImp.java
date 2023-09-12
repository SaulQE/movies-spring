package com.quispesucso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quispesucso.entity.Director;
import com.quispesucso.repository.DirectorRepository;

@Service
public class DirectorServiceImp implements DirectorService
{
	@Autowired
	private DirectorRepository repository;

	@Override
	@Transactional
	public void insert(Director director) {
		repository.save(director);
		
	}

	@Override
	@Transactional
	public void update(Director director) {
		repository.save(director);
		
	}

	@Override
	@Transactional
	public void delete(Integer directorId) {
		repository.deleteById(directorId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Director findById(Integer directorId) {
		return repository.findById(directorId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Director> findAll() {
		return repository.findAll();
	}
	
}
