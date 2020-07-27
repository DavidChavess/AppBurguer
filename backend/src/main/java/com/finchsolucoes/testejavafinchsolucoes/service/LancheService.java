package com.finchsolucoes.testejavafinchsolucoes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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
import com.finchsolucoes.testejavafinchsolucoes.service.business.promotion.PromocaoEnum;

@Service
public class LancheService {

	@Autowired
	private LancheRepository lancheRepository;
	
	@Autowired
	private IngredienteService ingredienteService; 
		
	public List<LancheDto> findAll() {
		return lancheRepository.findAll().stream().map(LancheDto::new).collect(Collectors.toList());
	}

	public LancheDto findById(Integer id) {
		Optional<Lanche> optional = lancheRepository.findById(id);
		if (optional.isPresent())
			return new LancheDto(optional.get());
		
		throw new ObjectNotFoundException(String.format("Lanche não encontrado! ID = %d ", id));
	}

	@Transactional
	public LancheDto insert(LancheDto lancheDto) {
		lancheDto.setId(null);
		return new LancheDto(lancheRepository.save(fromDto(lancheDto)));
	}

	public LancheDto update(Integer id, LancheDto lancheDto) {
		LancheDto antigo = findById(id);
		antigo.setId(id);
		antigo.setNome(lancheDto.getNome());
		antigo.setValor(lancheDto.getValor());
		return toDto(lancheRepository.save(fromDto(antigo)));
	}

	public void delete(Integer id) {
		try {
			lancheRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um Lanche, porque tem lanches que contém ele !");
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(String.format("Lanche não encontrado! ID = %d ", id));
		}
	}

	private Lanche fromDto(LancheDto dto) {
		Lanche lanche = new Lanche(dto.getId(), dto.getNome());
		lanche.getIngredientes()
			.addAll(dto.getIngredientes()
			.stream().map(item -> {
				 Ingrediente ingrediente = ingredienteService.fromDto(
						 ingredienteService.findById(item.getIngrediente().getId())
			 	 );				 
				return new ItemLanche(ingrediente, lanche, item.getQuantidade());
			})
			.collect(Collectors.toSet()));
	
		lanche.calculaValor();
		PromocaoEnum.aplicaPromocoes(lanche);
		lanche.calculaValor();	
		
		return lanche;
	}

	private LancheDto toDto(Lanche Lanche) {
		return new LancheDto(Lanche);
	}
}
