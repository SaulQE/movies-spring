package com.quispesucso.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "peliculas")
public class Pelicula 
{
	//Propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer peliculaId;
	
	@Column
	private String titulo;
	private String protagonista;
	private String idioma;
	private String director;
	private String genero;
	private Double precio;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate estreno;
	private Integer dur_minutos;
	
	//Constructor sin propiedades
	public Pelicula() {}

	//Constructor con propiedades
	public Pelicula(Integer peliculaId, String titulo, String protagonista, String idioma, String director,
			String genero, Double precio, LocalDate estreno, Integer dur_minutos) {
		this.peliculaId = peliculaId;
		this.titulo = titulo;
		this.protagonista = protagonista;
		this.idioma = idioma;
		this.director = director;
		this.genero = genero;
		this.precio = precio;
		this.estreno = estreno;
		this.dur_minutos = dur_minutos;
	}

	//Encapsulamiento de las propiedades
	public Integer getPeliculaId() {
		return peliculaId;
	}

	public void setPeliculaId(Integer peliculaId) {
		this.peliculaId = peliculaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public LocalDate getEstreno() {
		return estreno;
	}

	public void setEstreno(LocalDate estreno) {
		this.estreno = estreno;
	}

	public Integer getDur_minutos() {
		return dur_minutos;
	}

	public void setDur_minutos(Integer dur_minutos) {
		this.dur_minutos = dur_minutos;
	}
	
	
}
