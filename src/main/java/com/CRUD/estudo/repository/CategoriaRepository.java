package com.CRUD.estudo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.estudo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria save(Optional<Categoria> categoriaSalva);
}