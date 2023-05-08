package com.jotha.JothaTech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainControler {

	
	
	@GetMapping(value = "/home")
	public ModelAndView getMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}	
}