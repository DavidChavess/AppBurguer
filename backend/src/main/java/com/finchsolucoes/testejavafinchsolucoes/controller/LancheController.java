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
import com.finchsolucoes.testejavafinchsolucoes.service.LancheService;

@RestController
@RequestMapping("/lanches")
@CrossOrigin
public class LancheController {

	@Autowired
	private LancheService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<LancheDto> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public LancheDto findById(@PathVariable Integer id) {
		return service.findById(id);	
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LancheDto insert(@Valid @RequestBody LancheDto LancheDto) {
		return service.insert(LancheDto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public LancheDto update(@PathVariable Integer id, @Valid @RequestBody LancheDto LancheDto) {
		return service.update(id, LancheDto);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
