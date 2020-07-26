package com.finchsolucoes.testejavafinchsolucoes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.finchsolucoes.testejavafinchsolucoes.model.Ingrediente;
import com.finchsolucoes.testejavafinchsolucoes.repository.IngredienteRepository;

@SpringBootApplication
public class TesteJavaFinchSolucoesApplication implements CommandLineRunner {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(TesteJavaFinchSolucoesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ingrediente alface = new Ingrediente(null, "Alface", 0.40);
		Ingrediente bacon = new Ingrediente(null, "Bacon", 2.00);
		Ingrediente hamburguer = new Ingrediente(null, "Hambúrguer", 3.00);
		Ingrediente ovo = new Ingrediente(null, "Ovo", 0.80);
		Ingrediente queijo = new Ingrediente(null, "Queijo", 1.50);
		
		ingredienteRepository.saveAll(Arrays.asList(alface, bacon, hamburguer, ovo, queijo));
		
	}

}
