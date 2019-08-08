package com.alphaviagens.alphaviagens.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Reclamação")
public class Reclamacao implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	@NotEmpty(message = "O campo é obrigatório")
	private String nome;
	@Column(nullable = false)
	@NotEmpty(message = "O campo é obrigatório")
	private String sobrenome;
	@Column(nullable = false)
	@NotEmpty(message = "O campo é obrigatório")
	private String email;
	@Column(nullable = false)
	@NotEmpty(message = "O campo é obrigatório")
	private String mensagem;
	@Column(nullable = false)
	@NotEmpty(message = "O campo é obrigatório")
	private String assunto;
	
	//metodos especiais
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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	
}
