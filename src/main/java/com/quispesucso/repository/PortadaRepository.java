package com.quispesucso.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quispesucso.entity.Portada;

public interface PortadaRepository extends JpaRepository<Portada, Integer> 
{
	@Query(value = "SELECT * FROM portadas WHERE portada_id NOT IN (SELECT portada_id FROM peliculas)", nativeQuery = true)
	public abstract Collection<Portada> PortadaSinRelacionar();
}
