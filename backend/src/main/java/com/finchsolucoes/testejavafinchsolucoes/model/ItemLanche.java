package com.finchsolucoes.testejavafinchsolucoes.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finchsolucoes.testejavafinchsolucoes.model.pk.ItemLanchePK;

@Entity
public class ItemLanche {
	@EmbeddedId
	private ItemLanchePK id = new ItemLanchePK();
	
	private Integer quantidade;
	private Double valor;
	
	public ItemLanche() {}
	
	public ItemLanche(Ingrediente ingrediente, Lanche lanche, Integer quantidade) {
		this.id.setIngrediente(ingrediente);
		this.id.setLanche(lanche);
		this.valor = ingrediente.getPreco() * quantidade;
		this.quantidade = quantidade;
	}

	public Ingrediente getIngrediente() {
		return id.getIngrediente();
	}
	
	public void setIngrediente(Ingrediente ingrediente) {
		this.id.setIngrediente(ingrediente);
	}
	
	@JsonIgnore
	public Lanche getLanche() {
		return id.getLanche();
	}
	
	public void setLanche(Lanche lanche) {
		this.id.setLanche(lanche);
	}

	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
		
	}
	public void aplicaDesconto(Double desconto) {
		this.valor -= desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
