package com.finchsolucoes.testejavafinchsolucoes.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.finchsolucoes.testejavafinchsolucoes.dto.LancheDto;
import com.finchsolucoes.testejavafinchsolucoes.exception.DataIntegrityException;
import com.finchsolucoes.testejavafinchsolucoes.exception.ObjectNotFoundException;
import com.finchsolucoes.testejavafinchsolucoes.model.Ingrediente;
import com.finchsolucoes.testejavafinchsolucoes.model.ItemLanche;
import com.finchsolucoes.testejavafinchsolucoes.model.Lanche;
import com.finchsolucoes.testejavafinchsolucoes.repository.LancheRepository;

@Service
public class LancheService {

	@Autowired
	private LancheRepository repository;

	
	public List<LancheDto> findAll() {
		return repository.findAll().stream().map(LancheDto::new).collect(Collectors.toList());
	}

	public LancheDto findById(Integer id) {
		Optional<Lanche> obj = repository.findById(id);

		if (obj.isPresent())
			return new LancheDto(obj.get());

		throw new ObjectNotFoundException(String.format("Lanche não encontrado! ID = %d ", id));

	}

	public LancheDto insert(LancheDto LancheDto) {
		return new LancheDto(repository.save(fromDto(LancheDto)));
	}

	public LancheDto update(Integer id, LancheDto lancheDto) {
		LancheDto antigo = findById(id);
		antigo.setNome(lancheDto.getNome());
		antigo.setValor(lancheDto.getValor());
		return toDto(repository.save(fromDto(antigo)));
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um Lanche, porque tem lanches que contém ele !");
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(String.format("Lanche não encontrado! ID = %d ", id));
		}
	}

	private Lanche fromDto(LancheDto dto) {
		Lanche lanche = new Lanche(dto.getId(), dto.getNome(), dto.getValor());
		lanche.getIngredientes()
			.addAll(dto.getIngredientes()
			.stream().map(item -> {
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setId(item.getIngrediente().getId());
				return new ItemLanche(ingrediente, lanche, 0.0, item.getQuantidade());
			}).collect(Collectors.toSet()));

		return lanche;
	}

	private LancheDto toDto(Lanche Lanche) {
		return new LancheDto(Lanche);
	}

}
