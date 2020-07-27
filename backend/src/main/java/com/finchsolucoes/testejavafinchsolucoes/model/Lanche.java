package com.finchsolucoes.testejavafinchsolucoes.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lanche implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, updatable = false)
	private Integer id;
	
	@Column(name = "nome", unique = true, nullable = false, length = 80)
	private String nome;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@Column(name = "desconto", nullable = false)
	private double desconto;
	
	@OneToMany(mappedBy = "id.lanche", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ItemLanche> ingredientes = new HashSet<>();
	
	public Lanche() {}
	
	public Lanche(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	public void calculaValor() {
		this.valor = ingredientes
			.stream()
			.mapToDouble(ItemLanche::getValor)
			.sum() - desconto;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Set<ItemLanche> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<ItemLanche> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void adicionaDesconto(double desconto) {
		this.desconto += desconto;
	}
}
