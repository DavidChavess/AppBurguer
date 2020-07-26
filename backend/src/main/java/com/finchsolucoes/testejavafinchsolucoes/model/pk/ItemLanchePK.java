package com.finchsolucoes.testejavafinchsolucoes.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finchsolucoes.testejavafinchsolucoes.model.Ingrediente;
import com.finchsolucoes.testejavafinchsolucoes.model.Lanche;

@Embeddable
public class ItemLanchePK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "lache_id")
	private Lanche lanche;

	@ManyToOne
	@JoinColumn(name = "ingrediente_id")
	private Ingrediente ingrediente;
	
	@JsonIgnore
	public Lanche getLanche() {
		return lanche;
	}
	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}
	@JsonIgnore
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingrediente == null) ? 0 : ingrediente.hashCode());
		result = prime * result + ((lanche == null) ? 0 : lanche.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLanchePK other = (ItemLanchePK) obj;
		if (ingrediente == null) {
			if (other.ingrediente != null)
				return false;
		} else if (!ingrediente.equals(other.ingrediente))
			return false;
		if (lanche == null) {
			if (other.lanche != null)
				return false;
		} else if (!lanche.equals(other.lanche))
			return false;
		return true;
	}
	
}
