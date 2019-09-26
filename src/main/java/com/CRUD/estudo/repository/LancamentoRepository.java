package com.CRUD.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.estudo.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
