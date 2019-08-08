package com.alphaviagens.alphaviagens.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table (name="Viagem")
public class Viagem implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String local;
	// temporalType.TIMESTAMP, serve pra configurar a data e o horário //
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataViagem;
	@Column
	private String destino;
	@ManyToOne
	private Cidade cidade;
	@ManyToOne
	private Acomodacao acomodacao;
	@ManyToOne
	private FormaPagamento formaPagamento;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Date getData() {
		return dataViagem;
	}
	public void setData(Date dataViagem) {
		this.dataViagem = dataViagem;
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Acomodacao getAcomodacao() {
		return acomodacao;
	}
	public void setAcomodacao(Acomodacao acomodacao) {
		this.acomodacao = acomodacao;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
