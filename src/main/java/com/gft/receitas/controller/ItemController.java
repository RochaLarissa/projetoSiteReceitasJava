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

import com.gft.receitas.entities.Item;
import com.gft.receitas.services.IngredienteService;
import com.gft.receitas.services.ItemService;

import com.gft.receitas.services.UnidadeMedidaService;

@Controller
@RequestMapping("item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@RequestMapping("/editar") //ou criar
	public ModelAndView editarItem(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("item/form.html");
		Item item;
		
		if (id==null) {
			item = new Item();			
		} else {
			try {
				item = itemService.obterItem(id);
			}catch(Exception e) {
				item = new Item();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		
		mv.addObject("item", item);
		mv.addObject("listaUnidadeMedida", unidadeMedidaService.listarUnidadeMedida(null));
		mv.addObject("listaIngrediente", ingredienteService.listarIngrediente(null));
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.POST,path = "editar")
	public ModelAndView salvarItem(@Valid Item item, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("item/form.html");
		
		boolean novo = true;
		
		if(item.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("item", item);
			return mv;
		}

		itemService.salvarItem(item);
		
		if(novo) {
			mv.addObject("item", new Item());			
		} else {
			mv.addObject("item", item);
		}
		
		
		mv.addObject("mensagem", "Item salvo com sucesso");
		mv.addObject("listaUnidadeMedida", unidadeMedidaService.listarUnidadeMedida(null));
		mv.addObject("listaIngrediente", ingredienteService.listarIngrediente(null));
		
		return mv;
	}
	
	
	@RequestMapping
	public ModelAndView listarItem() {
		
		ModelAndView mv = new ModelAndView("item/listar.html");
		mv.addObject("lista", itemService.listarItem());
		
		return mv;
	}
	
	
	@RequestMapping("/excluir")
	public ModelAndView excluirItem(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/item");
		
		try {
			itemService.excluirItem(id);
			redirectAttributes.addFlashAttribute("mensagem", "Item excluído com sucesso!");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir item." + e.getMessage());
		}
		
		return mv;
	}

}
