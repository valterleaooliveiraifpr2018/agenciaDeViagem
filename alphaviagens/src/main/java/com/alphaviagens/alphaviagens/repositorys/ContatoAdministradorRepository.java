package com.alphaviagens.alphaviagens.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaviagens.alphaviagens.models.Reclamacao;

public interface ContatoAdministradorRepository extends JpaRepository<Reclamacao, Long> {
	 
//	List<Reclamacao> findById(long id);
	Optional<ContatoAdministradorRepository> findById(long id);
}
