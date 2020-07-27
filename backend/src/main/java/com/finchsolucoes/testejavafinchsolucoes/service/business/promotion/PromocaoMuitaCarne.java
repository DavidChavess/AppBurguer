package com.finchsolucoes.testejavafinchsolucoes.service.business.promotion;

import com.finchsolucoes.testejavafinchsolucoes.model.ItemLanche;
import com.finchsolucoes.testejavafinchsolucoes.model.Lanche;

public class PromocaoMuitaCarne implements PromocaoInterface{

	@Override
	public String getNome() {
		return "Muita carne";
	}

	@Override
	public String getDescricao() {
		return " A cada 3 porções de hambúrguer o cliente só paga 2, a cada 6 porções, o cliente pagará 4 e assim sucessivamente";
	}

	@Override
	public boolean podeReceberDesconto(Lanche lanche) {
		for(ItemLanche item : lanche.getIngredientes()) {
			if("Hamburguer".equalsIgnoreCase(item.getIngrediente().getNome())) {
				return item.getQuantidade() > 2;
			}
		}
		return false;
	}

	@Override
	public void aplicaDesconto(Lanche lanche) {
		for(ItemLanche item : lanche.getIngredientes()) {
			if("Hamburguer".equalsIgnoreCase(item.getIngrediente().getNome())) {
				int itensComDesconto = (int) Math.floor(item.getQuantidade() / 3);
				double valorDoDesconto = item.getIngrediente().getPreco() * itensComDesconto;
				item.aplicaDesconto(valorDoDesconto);
			}
		}
	}
}
