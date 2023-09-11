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
@Table(name = "clientes")
public class Cliente implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clienteId;
	private String nomCompleto;
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fnacimiento;
	private String correo;
	private String contraseña;
	private Integer telefono;
	
	@OneToMany(mappedBy = "cliente")
	private Collection<Boleto> itemsBoleto = new ArrayList<>();
	
	public Cliente() {	}

	public Cliente(Integer clienteId, String nomCompleto, LocalDate fnacimiento, String correo, String contraseña,
			Integer telefono) {
		this.clienteId = clienteId;
		this.nomCompleto = nomCompleto;
		this.fnacimiento = fnacimiento;
		this.correo = correo;
		this.contraseña = contraseña;
		this.telefono = telefono;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getNomCompleto() {
		return nomCompleto;
	}

	public void setNomCompleto(String nomCompleto) {
		this.nomCompleto = nomCompleto;
	}

	public LocalDate getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	//
	public Collection<Boleto> getItemsBoleto() {
		return itemsBoleto;
	}

	public void setItemsBoleto(Collection<Boleto> itemsBoleto) {
		this.itemsBoleto = itemsBoleto;
	}
	
	
}
