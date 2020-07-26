package com.finchsolucoes.testejavafinchsolucoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finchsolucoes.testejavafinchsolucoes.model.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>{

}
