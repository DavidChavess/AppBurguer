package com.finchsolucoes.testejavafinchsolucoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.finchsolucoes.testejavafinchsolucoes.exception.StandardError;
import com.finchsolucoes.testejavafinchsolucoes.service.IngredienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/ingredientes")
@CrossOrigin
@Api(tags = {"Ingredientes"})
public class IngredienteController {

	@Autowired
	private IngredienteService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Listagem de ingredientes")
	public List<IngredienteDto> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Buscar um ingrediente pelo id")
	@ApiResponses(value = @ApiResponse(code = 404, message = "Ingrediente não encontrado", response = StandardError.class))
	public IngredienteDto findById(@PathVariable Integer id) {
		return service.findById(id);	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Inserir ingrediente")
	@ApiResponses(value = @ApiResponse(code = 201, message = "Ingrediente inserido com sucesso"))
	public IngredienteDto insert(@Valid @RequestBody IngredienteDto ingredienteDto) {
		return service.insert(ingredienteDto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Alterar um ingrediente")
	@ApiResponses(value = @ApiResponse(code = 404, message = "Ingrediente não encontrado", response = StandardError.class))
	public IngredienteDto update(@PathVariable Integer id, @Valid @RequestBody IngredienteDto ingredienteDto) {
		return service.update(id, ingredienteDto);
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation("Deletar um ingrediente")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Ingrediente deletado com sucesso"),
			@ApiResponse(code = 400, message = "Não é possivel excluir um ingrediente, porque tem lanches que contém ele!", response = StandardError.class),
			@ApiResponse(code = 404, message = "Ingrediente não encontrado", response = StandardError.class),
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
