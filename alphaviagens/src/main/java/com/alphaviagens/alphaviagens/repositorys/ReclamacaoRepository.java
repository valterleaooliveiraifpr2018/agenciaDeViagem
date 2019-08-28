package com.alphaviagens.alphaviagens.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaviagens.alphaviagens.models.Reclamacao;

public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Long> {
	List<Reclamacao> findById(long id);
}
