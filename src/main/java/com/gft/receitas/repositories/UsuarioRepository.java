package com.gft.receitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.receitas.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);

}
