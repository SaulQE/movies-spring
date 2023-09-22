package com.quispesucso.service;

import java.util.Collection;

import com.quispesucso.entity.Sala;

public interface SalaService 
{
	public abstract void insert(Sala sala);
	public abstract void update(Sala sala);
	public abstract void delete(Integer salaId);
	public abstract Sala findById(Integer salaId);
	public abstract Collection<Sala> findAll();
}
