package com.quispesucso.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "salas")
public class Sala implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salaId;
	private String nombre;
	private Integer cantButacas;
	
	
	@OneToMany(mappedBy = "sala")
	private Collection<Boleto> itemsBoleto = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "sucursal_id", nullable = false)
	private Sucursal sucursal;
	
	@ManyToMany(mappedBy = "itemsSala")
	private Set<Pelicula> itemsPelicula = new HashSet<>();
	
	public Sala() {	}

	public Sala(Integer salaId, String nombre, Integer cantButacas) {
		this.salaId = salaId;
		this.nombre = nombre;
		this.cantButacas = cantButacas;
	}

	public Integer getSalaId() {
		return salaId;
	}


	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantButacas() {
		return cantButacas;
	}

	public void setCantButacas(Integer cantButacas) {
		this.cantButacas = cantButacas;
	}
	
	//
	public Set<Pelicula> getItemsPelicula() {
		return itemsPelicula;
	}
	
	public void setItemsPelicula(Set<Pelicula> itemsPelicula) {
		this.itemsPelicula = itemsPelicula;
	}
	
	//
	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	//
	public Collection<Boleto> getItemsBoleto() {
		return itemsBoleto;
	}

	public void setItemsBoleto(Collection<Boleto> itemsBoleto) {
		this.itemsBoleto = itemsBoleto;
	}
	
	
}
