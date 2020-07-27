package com.finchsolucoes.testejavafinchsolucoes.service.business.promotion;

import com.finchsolucoes.testejavafinchsolucoes.model.Lanche;

public enum PromocaoEnum {
	LIGHT(new PromocaoLight()),
	MUITA_CARNE(new PromocaoMuitaCarne()),
	MUITO_QUEIJO(new PromocaoMuitoQueijo())
	;
	
	private final PromocaoInterface promocao;
	
	PromocaoEnum(PromocaoInterface promocao) {
		this.promocao = promocao;
	}

	public PromocaoInterface getPromocao() {
		return promocao;
	}
	
	public static void aplicaPromocoes(Lanche lanche) {
		for(PromocaoEnum promocao : PromocaoEnum.values()) {
			if(promocao.getPromocao().podeReceberDesconto(lanche)) {
				promocao.getPromocao().aplicaDesconto(lanche);
			}
		}
	}
}
