package com.gft.receitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.receitas.entities.Usuario;
import com.gft.receitas.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public Usuario salvarUsuario(Usuario usuario) {

		return usuarioRepository.save(usuario);
	}

	
	public List<Usuario> listarUsuario() {

		return usuarioRepository.findAll();
	}

	
	public Usuario obterUsuario(Long id) throws Exception {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (usuario.isEmpty()) {
			throw new Exception("Usuário não encontrado");
		}

		return usuario.get();
	}

	
	public void excluirUsuario(Long id) throws Exception {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if (usuario.get().getPrivilegio().equals("admin")) {
			throw new Exception("Impossível excluir admin");
		}
		
		usuarioRepository.deleteById(id);
	}

}
