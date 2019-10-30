package com.alphaviagens.alphaviagens.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="Cidade acomodação")
public class CidAcomoda implements Serializable{
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
	@ManyToOne
private Cidade cidade;
	@ManyToOne
private Acomodacao acomoda;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Acomodacao getAcomoda() {
		return acomoda;
	}
	public void setAcomoda(Acomodacao acomoda) {
		this.acomoda = acomoda;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
