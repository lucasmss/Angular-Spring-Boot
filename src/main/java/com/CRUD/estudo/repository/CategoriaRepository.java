package com.CRUD.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.estudo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}