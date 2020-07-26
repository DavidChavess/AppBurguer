package com.finchsolucoes.testejavafinchsolucoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.finchsolucoes.testejavafinchsolucoes.dto.IngredienteDto;
import com.finchsolucoes.testejavafinchsolucoes.service.IngredienteService;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

	@Autowired
	private IngredienteService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<IngredienteDto> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public IngredienteDto findById(@PathVariable Integer id) {
		return service.findById(id);	
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public IngredienteDto insert(@Valid @RequestBody IngredienteDto ingredienteDto) {
		return service.insert(ingredienteDto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public IngredienteDto update(@PathVariable Integer id, @Valid @RequestBody IngredienteDto ingredienteDto) {
		return service.update(id, ingredienteDto);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
