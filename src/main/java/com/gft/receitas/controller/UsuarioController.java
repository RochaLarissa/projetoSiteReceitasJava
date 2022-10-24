package com.gft.receitas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.receitas.entities.Usuario;
import com.gft.receitas.services.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/editar") //ou criar
	public ModelAndView editarUsuario(@RequestParam(required = false) Long id) {
		
		ModelAndView mv = new ModelAndView("usuario/form.html");
		Usuario usuario;
		
		if (id==null) {
			usuario = new Usuario();			
		} else {
			try {
				usuario = usuarioService.obterUsuario(id);
			}catch(Exception e) {
				usuario = new Usuario();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.POST,path = "editar")
	public ModelAndView salvarUsuario(@Valid Usuario usuario, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("usuario/form.html");
		
		boolean novo = true;
		
		if(usuario.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("usuario", usuario);
			return mv;
		}

		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioService.salvarUsuario(usuario);
		
		if(novo) {
			mv.addObject("usuario", new Usuario());			
		} else {
			mv.addObject("usuario", usuario);
		}
		
		
		mv.addObject("mensagem", "Usuário salvo com sucesso");
		
		return mv;
	}
	
	
	@RequestMapping
	public ModelAndView listarUsuario() {
		
		ModelAndView mv = new ModelAndView("usuario/listar.html");
		mv.addObject("lista", usuarioService.listarUsuario());
		
		return mv;
	}
	
	
	@RequestMapping("/excluir")
	public ModelAndView excluirUsuario(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/usuario");
		
		try {
			usuarioService.excluirUsuario(id);
			redirectAttributes.addFlashAttribute("mensagem", "Usuário excluído com sucesso!");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir usuário." + e.getMessage());
		}
		
		return mv;
	}
	
	

}
