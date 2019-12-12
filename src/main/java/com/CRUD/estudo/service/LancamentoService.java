package com.CRUD.estudo.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.CRUD.estudo.model.Lancamento;
import com.CRUD.estudo.model.Pessoa;
import com.CRUD.estudo.repository.LancamentoRepository;
import com.CRUD.estudo.repository.PessoaRepository;

@Service
@EnableScheduling
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	
	public Lancamento salvar(@Valid Lancamento lancamento) throws Exception {
		
	
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		
		
		if(pessoa == null || pessoa.get().isInativo()) {
			
			throw new Exception("Pessoa tem que estar ativa");
		}
		
		return lancamentoRepository.save(lancamento);
	}

	
}
