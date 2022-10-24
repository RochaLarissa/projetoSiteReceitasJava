package com.gft.receitas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.receitas.entities.UnidadeMedida;
import com.gft.receitas.services.UnidadeMedidaService;

@Controller
@RequestMapping("unidademedida")
public class UnidadeMedidaController {
	
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	@RequestMapping("/editar") //ou criar
	public ModelAndView editarUnidadeMedida(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("unidademedida/form.html");
		UnidadeMedida unidadeMedida;
		
		if (id==null) {
			unidadeMedida = new UnidadeMedida();			
		} else {
			try {
				unidadeMedida = unidadeMedidaService.obterUnidadeMedida(id);
			}catch(Exception e) {
				unidadeMedida = new UnidadeMedida();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		
		mv.addObject("unidadeMedida", unidadeMedida);
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.POST,path = "editar")
	public ModelAndView salvarunidadeMedida(@Valid UnidadeMedida unidadeMedida, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("unidademedida/form.html");
		
		boolean novo = true;
		
		if(unidadeMedida.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("unidadeMedida", unidadeMedida);
			return mv;
		}

		unidadeMedidaService.salvarUnidadeMedida(unidadeMedida);
		
		if(novo) {
			mv.addObject("unidadeMedida", new UnidadeMedida());			
		} else {
			mv.addObject("unidadeMedida", unidadeMedida);
		}
		
		
		mv.addObject("mensagem", "Unidade de medida salva com sucesso");
		
		return mv;
	}
	
	
	@RequestMapping
	public ModelAndView listarUnidadeMedida(String tipoUnidadeMedida) {
		
		ModelAndView mv = new ModelAndView("unidademedida/listar.html");
		mv.addObject("lista", unidadeMedidaService.listarUnidadeMedida(tipoUnidadeMedida));
		
		mv.addObject("tipoUnidadeMedida", tipoUnidadeMedida);
		
		return mv;
	}
	
	
	@RequestMapping("/excluir")
	public ModelAndView excluirUnidadeMedida(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/unidademedida");
		
		try {
			unidadeMedidaService.excluirUnidadeMedida(id);
			redirectAttributes.addFlashAttribute("mensagem", "Unidade de medida excluída com sucesso!");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir unidade de medida. Não é possível excluir unidades de medida"
					+ " em uso. É necessário primeiro corrigir ou excluir as receitas que usam esta unidade de medida.");
		}
		
		return mv;
	}

}
