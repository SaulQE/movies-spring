package com.quispesucso.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable
{
	private static final long serialVersionUID = 1L;

	//Propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer peliculaId;
	
	@Column
	private String titulo;
	private String protagonista;
	private String idioma;
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate estreno;
	private String genero;
	private Integer dur_minutos;
	private Double puntuacion;
	
	@ManyToOne
	@JoinColumn(name ="director_id", nullable = false)
	private Director director;
	
	@ManyToMany
	@JoinTable(name = "peliculas_sala",
			joinColumns = @JoinColumn(name="pelicula_id"),
			inverseJoinColumns = @JoinColumn(name="sala_id"))
	private Set<Sala> itemsSala = new HashSet<>();
	
	//Constructor sin propiedades
	public Pelicula() {}

	//Constructor con propiedades
	public Pelicula(Integer peliculaId, String titulo, String protagonista, String idioma, LocalDate estreno,
			String genero, Integer dur_minutos, Double puntuacion) {
		this.peliculaId = peliculaId;
		this.titulo = titulo;
		this.protagonista = protagonista;
		this.idioma = idioma;
		this.estreno = estreno;
		this.genero = genero;
		this.dur_minutos = dur_minutos;
		this.puntuacion = puntuacion;
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

	public LocalDate getEstreno() {
		return estreno;
	}

	public void setEstreno(LocalDate estreno) {
		this.estreno = estreno;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getDur_minutos() {
		return dur_minutos;
	}

	public void setDur_minutos(Integer dur_minutos) {
		this.dur_minutos = dur_minutos;
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}

	
	//
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	//
	public Set<Sala> getItemsSala() {
		return itemsSala;
	}

	public void setItemsSala(Set<Sala> itemsSala) {
		this.itemsSala = itemsSala;
	}
	
	
	
}
