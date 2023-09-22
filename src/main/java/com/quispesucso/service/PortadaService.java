package com.quispesucso.service;

import java.util.Collection;

import com.quispesucso.entity.Portada;

public interface PortadaService 
{
	public abstract void insert(Portada portada);
	public abstract void update(Portada portada);
	public abstract void delete(Integer portadaId);
	public abstract Portada findById(Integer portadaId);
	public abstract Collection<Portada> findAll();
	
	public abstract Collection<Portada> PortadaSinRelacionar();
}
