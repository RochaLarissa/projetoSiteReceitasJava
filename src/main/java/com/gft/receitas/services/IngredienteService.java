package com.gft.receitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.receitas.entities.Ingrediente;
import com.gft.receitas.repositories.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	
	public Ingrediente salvarIngrediente(Ingrediente ingrediente) {
		
		return ingredienteRepository.save(ingrediente);
	}
	
	
	public List<Ingrediente> listarIngrediente(String nomeIngrediente) {
		
		if(nomeIngrediente != null) {
			return ingredienteRepository.findByNomeIngredienteContains(nomeIngrediente);		
		} else {
			return ingredienteRepository.findAll();			
		}
	}
	
	
	public Ingrediente obterIngrediente(Long id) throws Exception{
		
		Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
		
		if(ingrediente.isEmpty()) {
			throw new Exception("Ingrediente não encontrado");
		}
		
		return ingrediente.get();
	}
	
	
	public void excluirIngrediente(Long id) {
		
		ingredienteRepository.deleteById(id);
	}

}
