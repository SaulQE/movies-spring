package com.quispesucso.entity;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tika.Tika;

@Entity
@Table(name = "portadas")
public class Portada implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer portadaId;
	private String nombre;
	@Column(columnDefinition = "longblob")
	private byte[] archivo;
	
	@OneToOne(mappedBy = "portada")
	private Pelicula pelicula;
	
	public Portada() {	}

	public Portada(Integer portadaId, String nombre, byte[] archivo) {
		this.portadaId = portadaId;
		this.nombre = nombre;
		this.archivo = archivo;
	}
	
	

	public Integer getPortadaId() {
		return portadaId;
	}

	public void setPortadaId(Integer portadaId) {
		this.portadaId = portadaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	//
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	//Obtener archivo en base64
	public String getBase64Image() {
		return Base64.getEncoder().encodeToString(this.archivo);
	}
	
	//Obtener el tipo de archivo (jpeg,jpg,png,gif...)
	public String getTypeImage() {
		return new Tika().detect(this.archivo);
	}
}
