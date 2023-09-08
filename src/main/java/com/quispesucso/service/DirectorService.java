package com.quispesucso.service;

import java.util.Collection;

import com.quispesucso.entity.Director;

public interface DirectorService 
{
	//Servicios
	public abstract void insert(Director director);
	public abstract void update(Director director);
	public abstract void delete(Integer directorId);
	public abstract Director findById(Integer directorId);
	public abstract Collection<Director> findAll();
}
