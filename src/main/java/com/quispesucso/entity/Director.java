package com.quispesucso.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "directores")
public class Director implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer directorId;
	private String nombre;
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fnacimiento;
	private String pais;
	
	@OneToMany(mappedBy = "director")
	private Collection<Pelicula> itemsPelicula = new ArrayList<>();
	
	//Constructor sin proiedades
	public Director() {	}

	//Constructor con proiedades
	public Director(Integer directorId, String nombre, LocalDate fnacimiento, String pais) {
		this.directorId = directorId;
		this.nombre = nombre;
		this.fnacimiento = fnacimiento;
		this.pais = pais;
	}

	public Integer getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Collection<Pelicula> getItemsPelicula() {
		return itemsPelicula;
	}

	public void setItemsPelicula(Collection<Pelicula> itemsPelicula) {
		this.itemsPelicula = itemsPelicula;
	}

	
	
	
}
