package com.CRUD.estudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.CRUD.estudo.model.Pessoa;
import com.CRUD.estudo.repository.PessoaRepository;

@Service
@EnableScheduling
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Pessoa atualizar (Long codigo, Pessoa pessoa){

		Long pessoaCod = pessoa.getCodigo();
		String nomePessoa = pessoa.getNome();
		
		if(pessoaCod == codigo && nomePessoa != null) {
			
		return pessoaRepository.save(pessoa);
		
		}else {
			
			 throw new EmptyResultDataAccessException(1);
		}
		
	}



}
