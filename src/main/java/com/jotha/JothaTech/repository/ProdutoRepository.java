package com.jotha.JothaTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotha.JothaTech.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
