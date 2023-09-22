package com.quispesucso.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "boletos")
public class Boleto implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer boletoId;
	private Integer nroButaca;
	private Double precio;
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fcompra;
	private String tipoBoleto;
	
	@ManyToOne
	@JoinColumn(name = "sala_id", nullable = false)
	private Sala sala;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	public Boleto() {}

	public Boleto(Integer boletoId, Integer nroButaca, Double precio, LocalDate fcompra, Integer nroSala,
			String tipoBoleto) {
		this.boletoId = boletoId;
		this.nroButaca = nroButaca;
		this.precio = precio;
		this.fcompra = fcompra;
		this.tipoBoleto = tipoBoleto;
	}

	public Integer getBoletoId() {
		return boletoId;
	}

	public void setBoletoId(Integer boletoId) {
		this.boletoId = boletoId;
	}

	public Integer getNroButaca() {
		return nroButaca;
	}

	public void setNroButaca(Integer nroButaca) {
		this.nroButaca = nroButaca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public LocalDate getFcompra() {
		return fcompra;
	}

	public void setFcompra(LocalDate fcompra) {
		this.fcompra = fcompra;
	}

	public String getTipoBoleto() {
		return tipoBoleto;
	}

	public void setTipoBoleto(String tipoBoleto) {
		this.tipoBoleto = tipoBoleto;
	}

	
	//
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	//
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
