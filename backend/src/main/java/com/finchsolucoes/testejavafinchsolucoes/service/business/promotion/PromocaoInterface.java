package com.finchsolucoes.testejavafinchsolucoes.service.business.promotion;

import com.finchsolucoes.testejavafinchsolucoes.model.Lanche;

public interface PromocaoInterface {
	
	String getNome();
	String getDescricao();
	boolean podeReceberDesconto(Lanche lanche);
	void aplicaDesconto(Lanche lanche);
}
