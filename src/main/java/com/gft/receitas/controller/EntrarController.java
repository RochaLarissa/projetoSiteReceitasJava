package com.gft.receitas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("entrar")
public class EntrarController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String entrar() {
		return "entrar";
	}

}
