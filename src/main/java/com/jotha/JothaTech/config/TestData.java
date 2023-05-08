package com.jotha.JothaTech.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jotha.JothaTech.model.Produto;
import com.jotha.JothaTech.repository.ProdutoRepository;


public class TestData implements CommandLineRunner{
	
	@Autowired
	private ProdutoRepository pdr;

	@Override
	public void run(String... args) throws Exception {
		
		pdr.deleteAll();
		
		Produto p1 = new Produto(null, "Fone de ouvido", "Apple", "Branco", 15.0, 5);
		Produto p2 = new Produto(null, "Capinha", "Iphone X", "Verde", 35.0, 15);
		
		pdr.saveAll(Arrays.asList(p1, p2));
		
	}

}
