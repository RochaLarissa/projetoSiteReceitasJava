package com.gft.receitas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.receitas.entities.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
	
	List<Receita> findByNomeReceitaContains(String nomeReceita);
	
	List<Receita> findByNomeReceitaContainsAndListaIngredientesIngredienteNomeIngredienteContains(String nomeReceita, String nomeIngrediente);

}
