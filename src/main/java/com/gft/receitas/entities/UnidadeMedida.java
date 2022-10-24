package com.gft.receitas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class UnidadeMedida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String tipoUnidadeMedida;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoUnidadeMedida() {
		return tipoUnidadeMedida;
	}

	public void setTipoUnidadeMedida(String tipoUnidadeMedida) {
		this.tipoUnidadeMedida = tipoUnidadeMedida;
	}
	
	

}
