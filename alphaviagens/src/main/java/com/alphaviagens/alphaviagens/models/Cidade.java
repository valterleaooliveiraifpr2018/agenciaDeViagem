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
import javax.validation.constraints.NotEmpty;
@Entity
@Table (name= "Cidade")
public class Cidade implements Serializable {
 private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 @Column(nullable=false,length = 100)
 @NotEmpty(message="O nome da cidade é obrigatório")
 private String nome;
 @ManyToOne
 private Estado estado;

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
public Estado getEstado() {
	return estado;
}
public void setEstado(Estado estado) {
	this.estado = estado;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
 
}
