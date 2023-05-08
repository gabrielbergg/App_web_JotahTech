package com.jotha.JothaTech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotha.JothaTech.model.Produto;
import com.jotha.JothaTech.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long id) {
		return produtoRepository.findById(id).get();
	}
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
 	
}
