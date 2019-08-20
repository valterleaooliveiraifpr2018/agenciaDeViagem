package com.alphaviagens.alphaviagens.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaviagens.alphaviagens.models.Reclamacao;

public interface ContatoAdministradorRepository extends JpaRepository<Reclamacao, Long> {
	 
	
}
