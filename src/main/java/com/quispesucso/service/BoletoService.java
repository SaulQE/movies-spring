package com.quispesucso.service;

import java.util.Collection;

import com.quispesucso.entity.Boleto;

public interface BoletoService 
{
	public abstract void insert(Boleto boleto);
	public abstract void update(Boleto boleto);
	public abstract void delete(Integer boletoId);
	public abstract Boleto findById(Integer boletoId);
	public abstract Collection<Boleto> findAll();
}
