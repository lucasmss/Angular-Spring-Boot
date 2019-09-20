package com.CRUD.estudo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.CRUD.estudo.model.Pessoa;
import com.CRUD.estudo.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);
		if(pessoaSalva == null) {
			
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(pessoa, pessoaSalva);
		return pessoaRepository.save(pessoaSalva);
		
	}
	

}
