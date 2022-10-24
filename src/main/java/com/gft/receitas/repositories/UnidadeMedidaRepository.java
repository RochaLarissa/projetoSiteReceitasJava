package com.gft.receitas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.receitas.entities.UnidadeMedida;

public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Long>{
	
	List<UnidadeMedida> findByTipoUnidadeMedidaContains(String tipoUnidadeMedida);

}
