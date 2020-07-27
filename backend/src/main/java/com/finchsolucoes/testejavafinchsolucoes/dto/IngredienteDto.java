package com.finchsolucoes.testejavafinchsolucoes.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import com.finchsolucoes.testejavafinchsolucoes.model.Ingrediente;

public class IngredienteDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O campo nome é obrigatório!")
	@Length(min = 3, max = 80, message = "O campo nome deve ter entre 3 e 80 caracteres!")
	private String nome;
	
	@PositiveOrZero(message = "O preço não pode ser negativo!")
	private Double preco;
	
	public IngredienteDto() {}

	public IngredienteDto(Ingrediente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}	
}
