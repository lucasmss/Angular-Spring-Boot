package com.CRUD.estudo.repository.lancamento;

import java.util.List;

import com.CRUD.estudo.model.Lancamento;
import com.CRUD.estudo.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery{
	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);

}
