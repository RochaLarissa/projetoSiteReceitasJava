package com.gft.receitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.receitas.entities.UnidadeMedida;
import com.gft.receitas.repositories.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaService {

	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;

	
	public UnidadeMedida salvarUnidadeMedida(UnidadeMedida unidadeMedida) {

		return unidadeMedidaRepository.save(unidadeMedida);
	}

	
	public List<UnidadeMedida> listarUnidadeMedida(String tipoUnidadeMedida) {

		if(tipoUnidadeMedida != null) {
			return unidadeMedidaRepository.findByTipoUnidadeMedidaContains(tipoUnidadeMedida);						
		} else {
			return unidadeMedidaRepository.findAll();			
		}
	}

	
	public UnidadeMedida obterUnidadeMedida(Long id) throws Exception {

		Optional<UnidadeMedida> unidadeMedida = unidadeMedidaRepository.findById(id);

		if (unidadeMedida.isEmpty()) {
			throw new Exception("Unidade de medida não encontrada");
		}

		return unidadeMedida.get();
	}

	
	public void excluirUnidadeMedida(Long id) {

		unidadeMedidaRepository.deleteById(id);
	}

}
