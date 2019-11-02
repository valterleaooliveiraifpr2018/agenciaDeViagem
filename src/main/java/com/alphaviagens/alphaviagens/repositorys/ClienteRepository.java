package com.alphaviagens.alphaviagens.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaviagens.alphaviagens.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
