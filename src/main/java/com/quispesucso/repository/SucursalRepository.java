package com.quispesucso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quispesucso.entity.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> 
{
	
}
