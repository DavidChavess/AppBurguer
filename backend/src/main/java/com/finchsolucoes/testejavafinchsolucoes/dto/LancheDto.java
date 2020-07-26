package com.finchsolucoes.testejavafinchsolucoes.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.finchsolucoes.testejavafinchsolucoes.model.Lanche;

public class LancheDto {
	
	private Integer id;
	private String nome;
	private Double valor;
	
	private Set<ItemLancheDto> ingredientes = new HashSet<>();
		
	public LancheDto(){}
	
	public LancheDto(Lanche obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.valor = obj.getValor();
		
		this.ingredientes = obj.getIngredientes()
				.stream()
				.map(ItemLancheDto::new)
				.collect(Collectors.toSet());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Set<ItemLancheDto> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<ItemLancheDto> ingredientes) {
		this.ingredientes = ingredientes;
	}

}
