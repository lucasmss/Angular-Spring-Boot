package com.CRUD.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.estudo.model.Lancamento;
import com.CRUD.estudo.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{

}
