package com.alphaviagens.alphaviagens.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="LocaisCidades")
public class LocaisCidades implements Serializable{
private static final long serialVersioUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
	@ManyToOne
private LocaisTransportes locais;
	@ManyToOne
private Cidade cidade;


}
