package com.finchsolucoes.testejavafinchsolucoes.service.business.promotion;

import com.finchsolucoes.testejavafinchsolucoes.model.ItemLanche;
import com.finchsolucoes.testejavafinchsolucoes.model.Lanche;

public class PromocaoLight implements PromocaoInterface {

	@Override
	public String getNome() {
		return "Light";
	}

	@Override
	public String getDescricao() {
		return "Se o lanche tem alface e não tem bacon, ganha 10% de desconto";
	}

	@Override
	public boolean podeReceberDesconto(Lanche lanche) {
		boolean temAlface = false;
		boolean temBacon = false;
		
		for(ItemLanche item : lanche.getIngredientes()) {
			if("Alface".equalsIgnoreCase(item.getIngrediente().getNome())) {
				temAlface = true;
			}
			
			if("Bacon".equalsIgnoreCase(item.getIngrediente().getNome())) {
				temBacon = true;
			}
		}
		
		return temAlface && !temBacon;
	}

	@Override
	public void aplicaDesconto(Lanche lanche) {
		lanche.adicionaDesconto(lanche.getValor() * 0.1); 
	}

}
