package com.jotha.JothaTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jotha.JothaTech.model.Produto;
import com.jotha.JothaTech.service.ProdutoService;

import jakarta.validation.Valid;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	
	@GetMapping(value = "/produtos")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("produtos");
		List<Produto> produtos = produtoService.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@GetMapping(value = "/produtos/{id}")
	public ModelAndView findById(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("produtosDetails");
		Produto produto = produtoService.findById(id);
		mv.addObject("produto", produto);
		return mv;
	}
	
	@GetMapping(value = "/newproduto")
	public String newPost() {
		return "novosProdutos";
	}
	
	@PostMapping(value = "/newproduto")
	public String savePost(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {	
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios estão preenchidos!");
			return "redirect:/newpost";
		}
		produtoService.save(produto);
		return "redirect:/produtos";
	}
	
	@GetMapping(value = "/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("/editar");
		mv.addObject("produto", produtoService.findById(id));
		produtoService.delete(id);
		return mv;
	}
	
	@PostMapping(value = "/editar-produto")
	public ModelAndView editar(Produto produto) {
		ModelAndView mv = new ModelAndView("/editar");
		produtoService.save(produto);
		return findAll();
	}
	

	@GetMapping(value = "/remover/{id}")
	public ModelAndView remove(@PathVariable("id") Long id) {
		produtoService.delete(id);
		return findAll();
	}
	
}
