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

import com.finchsolucoes.testejavafinchsolucoes.dto.LancheDto;
import com.finchsolucoes.testejavafinchsolucoes.exception.StandardError;
import com.finchsolucoes.testejavafinchsolucoes.service.LancheService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/lanches")
@CrossOrigin
@Api(tags = {"Lanches"})
public class LancheController {

	@Autowired
	private LancheService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Listagem de lanches")
	public List<LancheDto> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Buscar um lanche pelo id")
	@ApiResponses(value = @ApiResponse(code = 404, message = "Lanche não encontrado", response = StandardError.class))
	public LancheDto findById(@PathVariable Integer id) {
		return service.findById(id);	
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Inserir um lanche")
	@ApiResponses(value = @ApiResponse(code = 201, message = "Lanche inserido com sucesso"))
	public LancheDto insert(@Valid @RequestBody LancheDto LancheDto) {
		return service.insert(LancheDto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Alterar um lanche")
	@ApiResponses(value = @ApiResponse(code = 404, message = "Lanche não encontrado", response = StandardError.class))
	public LancheDto update(@PathVariable Integer id, @Valid @RequestBody LancheDto LancheDto) {
		return service.update(id, LancheDto);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Deletar um lanche")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Lanche deletado com sucesso"),
			@ApiResponse(code = 404, message = "Lanche não encontrado", response = StandardError.class),
	})
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
