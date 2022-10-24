package com.gft.receitas.entities;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;


@Entity
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nomeReceita;
	
	@ManyToMany
	private List<Item> listaIngredientes;
	
	private String listaItemStringona;
	
	@NotEmpty
	private String tempoPreparo;
	
	@NotEmpty
	@Column(length = 10000)
	private String modoPreparo;
	
	private String rendimento;
	
	private String dificuldade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeReceita() {
		return nomeReceita;
	}

	public void setNomeReceita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}

	

	public String getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(String tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public String getRendimento() {
		return rendimento;
	}

	public void setRendimento(String rendimento) {
		this.rendimento = rendimento;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}

	public List<Item> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<Item> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	public String getListaItemStringona() {
		return listaItemStringona;
	}

	public void setListaItemStringona(String listaItemStringona) {
		this.listaItemStringona = listaItemStringona;
	}

	

	

}
