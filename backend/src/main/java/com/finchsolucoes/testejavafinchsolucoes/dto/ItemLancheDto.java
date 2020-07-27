package com.finchsolucoes.testejavafinchsolucoes.dto;

import javax.validation.constraints.Positive;

import com.finchsolucoes.testejavafinchsolucoes.model.Ingrediente;
import com.finchsolucoes.testejavafinchsolucoes.model.ItemLanche;

public class ItemLancheDto {
	
	@Positive(message = "A quantidade deve ser maior que zero!")
	private Integer quantidade;
	private Double valor;
	private IngredienteDto ingrediente;
	
	ItemLancheDto() {}
	
	public ItemLancheDto(ItemLanche obj) {
		this.quantidade = obj.getQuantidade();
		this.valor = obj.getValor();
		this.ingrediente = toDto(obj.getIngrediente());
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public IngredienteDto getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(IngredienteDto ingrediente) {
		this.ingrediente = ingrediente;
	}
	private IngredienteDto toDto(Ingrediente dto) {
		return new IngredienteDto(dto);
	}
}
