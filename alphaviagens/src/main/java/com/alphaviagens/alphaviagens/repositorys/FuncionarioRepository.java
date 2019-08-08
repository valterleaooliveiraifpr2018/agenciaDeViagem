package com.alphaviagens.alphaviagens.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaviagens.alphaviagens.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
