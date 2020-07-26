package com.finchsolucoes.testejavafinchsolucoes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.finchsolucoes.testejavafinchsolucoes.dto.IngredienteDto;
import com.finchsolucoes.testejavafinchsolucoes.exception.DataIntegrityException;
import com.finchsolucoes.testejavafinchsolucoes.exception.ObjectNotFoundException;
import com.finchsolucoes.testejavafinchsolucoes.model.Ingrediente;
import com.finchsolucoes.testejavafinchsolucoes.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository repository;

	public List<IngredienteDto> findAll() {
		return repository.findAll().stream().map(IngredienteDto::new).collect(Collectors.toList());
	}

	public IngredienteDto findById(Integer id) {
		Optional<Ingrediente> obj = repository.findById(id);

		if (obj.isPresent())
			return new IngredienteDto(obj.get());

		throw new ObjectNotFoundException(String.format("Ingrediente não encontrado! ID = %d ", id));

	}

	public IngredienteDto insert(IngredienteDto ingredienteDto) {
		return new IngredienteDto(repository.save(fromDto(ingredienteDto)));
	}

	public IngredienteDto update(Integer id, IngredienteDto ingredienteDto) {
		IngredienteDto antigo = findById(id);
		antigo.setNome(ingredienteDto.getNome());
		antigo.setPreco(ingredienteDto.getPreco());
		return toDto(repository.save(fromDto(antigo)));
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possivel excluir um ingrediente, porque tem lanches que contém ele !");
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(String.format("Ingrediente não encontrado! ID = %d ", id));
		}
	}

	private Ingrediente fromDto(IngredienteDto dto) {
		return new Ingrediente(dto.getId(), dto.getNome(), dto.getPreco());
	}
	
	private IngredienteDto toDto(Ingrediente ingrediente) {
		return new IngredienteDto(ingrediente);
	}
	
}
