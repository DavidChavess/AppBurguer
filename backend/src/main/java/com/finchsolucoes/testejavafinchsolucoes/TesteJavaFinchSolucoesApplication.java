package com.finchsolucoes.testejavafinchsolucoes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.finchsolucoes.testejavafinchsolucoes.model.Ingrediente;
import com.finchsolucoes.testejavafinchsolucoes.model.ItemLanche;
import com.finchsolucoes.testejavafinchsolucoes.model.Lanche;
import com.finchsolucoes.testejavafinchsolucoes.repository.IngredienteRepository;
import com.finchsolucoes.testejavafinchsolucoes.repository.LancheRepository;

@SpringBootApplication
public class TesteJavaFinchSolucoesApplication implements CommandLineRunner {

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Autowired
	private LancheRepository lancheRepository;


	public static void main(String[] args) {
		SpringApplication.run(TesteJavaFinchSolucoesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ingrediente alface = new Ingrediente(null, "Alface", 0.40);
		Ingrediente bacon = new Ingrediente(null, "Bacon", 2.00);
		Ingrediente hamburguer = new Ingrediente(null, "Hamburguer", 3.00);
		Ingrediente ovo = new Ingrediente(null, "Ovo", 0.80);
		Ingrediente queijo = new Ingrediente(null, "Queijo", 1.50);

		ingredienteRepository.saveAll(Arrays.asList(alface, bacon, hamburguer, ovo, queijo));
		 
		Lanche xBacon = new Lanche(null, "X-Bacon");
		
		xBacon.getIngredientes().addAll(Arrays.asList(
				new ItemLanche(bacon, xBacon, 1),
				new ItemLanche(hamburguer, xBacon, 1),
				new ItemLanche(queijo, xBacon, 1))
		);
		
		xBacon.calculaValor();
		lancheRepository.save(xBacon);
		
		 
		Lanche xBurguer = new Lanche(null, "X-Burguer");
		
		xBurguer.getIngredientes().addAll(Arrays.asList(
				new ItemLanche(hamburguer, xBurguer, 1),
				new ItemLanche(queijo, xBurguer, 1))
		);
		
		xBurguer.calculaValor();	
		lancheRepository.save(xBurguer);
		
		
		Lanche xEgg = new Lanche(null, "X-Egg");
		
		xEgg.getIngredientes().addAll(Arrays.asList(
				new ItemLanche(hamburguer, xEgg, 1),
				new ItemLanche(ovo, xEgg, 1),
				new ItemLanche(queijo, xEgg, 1))
		);
		
		xEgg.calculaValor();	
		lancheRepository.save(xEgg);
		
		Lanche xEggBacon = new Lanche(null, "X-Egg Bacon");
		
		xEggBacon.getIngredientes().addAll(Arrays.asList(
				new ItemLanche(hamburguer, xEggBacon, 1),
				new ItemLanche(ovo, xEggBacon, 1),
				new ItemLanche(queijo, xEggBacon, 1),
				new ItemLanche(bacon, xEggBacon, 1))
		);
		
		xEggBacon.calculaValor();	
		lancheRepository.save(xEggBacon);
	}

}
