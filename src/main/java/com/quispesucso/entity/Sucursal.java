package com.quispesucso.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sucursales")
public class Sucursal implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sucursalId;
	private String nombre;
	private String direccion;
	private Integer telefono;
	
	@OneToMany(mappedBy = "sucursal")
	private Collection<Sala> itemsSala = new ArrayList<>();
	
	public Sucursal() {	}

	public Sucursal(Integer sucursalId, String nombre, String direccion, Integer telefono) {
		this.sucursalId = sucursalId;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Integer getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	//
	public Collection<Sala> getItemsSala() {
		return itemsSala;
	}

	public void setItemsSala(Collection<Sala> itemsSala) {
		this.itemsSala = itemsSala;
	}
	
	
	
}
