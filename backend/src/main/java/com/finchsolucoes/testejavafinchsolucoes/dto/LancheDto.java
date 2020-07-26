package com.finchsolucoes.testejavafinchsolucoes.dto;

import com.finchsolucoes.testejavafinchsolucoes.model.Lanche;

public class LancheDto {
	
	private Integer id;
	private String nome;
	private Double valor;
	
	public LancheDto(){}
	
	public LancheDto(Lanche obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.valor = obj.getValor();
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
}
