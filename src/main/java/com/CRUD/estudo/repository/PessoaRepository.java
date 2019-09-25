package com.CRUD.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.estudo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	void save(boolean pessoaAtiva);


}
