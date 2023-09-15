package com.quispesucso.service;

import java.util.Collection;

import com.quispesucso.entity.Sucursal;

public interface SucursalService 
{
	public abstract void insert(Sucursal sucursal);
	public abstract void update(Sucursal sucursal);
	public abstract void delete(Integer sucursalId);
	public abstract Sucursal findById(Integer sucursalId);
	public abstract Collection<Sucursal> findAll();
}
