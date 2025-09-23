package com.Login.repository;

import com.Login.entities.Produtos;

import org.springframework.data.jpa.repository.JpaRepository;
public interface produtosRepository extends JpaRepository<Produtos, Long> {
}

