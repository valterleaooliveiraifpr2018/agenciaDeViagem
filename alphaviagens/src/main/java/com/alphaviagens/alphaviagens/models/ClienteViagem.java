package com.alphaviagens.alphaviagens.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name="Cliente_Viagens")
public class ClienteViagem implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private Cliente cliente;
	@Column
	private Viagem viagem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Viagem getViagem() {
		return viagem;
	}
	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
