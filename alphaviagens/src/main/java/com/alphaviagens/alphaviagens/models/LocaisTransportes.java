package com.alphaviagens.alphaviagens.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name="Locais_Transportes")
public class LocaisTransportes implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String tipoTransporte;
	@Column
	private Double valor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoTransporte() {
		return tipoTransporte;
	}
	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
