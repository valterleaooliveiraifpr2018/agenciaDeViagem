package com.alphaviagens.alphaviagens.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table (name="Formas_De_Pagamentos")
public class FormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	@Column
	private Double pagTotal;
	@Column
	private Double formPga;
	@ManyToOne
	private Cliente cliente;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPagTotal() {
		return pagTotal;
	}
	public void setPagTotal(Double pagTotal) {
		this.pagTotal = pagTotal;
	}
	public Double getFormPga() {
		return formPga;
	}
	public void setFormPga(Double formPga) {
		this.formPga = formPga;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
