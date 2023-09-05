package com.quispesucso.service;

import java.util.Collection;

import com.quispesucso.entity.Pelicula;

public interface PeliculaService 
{
	//Se define los servicios
	public abstract void insert(Pelicula pelicula);
	public abstract void update(Pelicula pelicula);
	public abstract void delete(Integer peliculaId);
	public abstract Pelicula findById(Integer peliculaId);
	public abstract Collection<Pelicula> findAll();
	
	public abstract Integer sumMinutos();
}
