package com.gft.receitas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.receitas.entities.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
	
	List<Ingrediente> findByNomeIngredienteContains(String nomeIngrediente);

}
