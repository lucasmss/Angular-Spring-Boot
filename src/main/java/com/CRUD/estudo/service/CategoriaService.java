package com.CRUD.estudo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.CRUD.estudo.model.Categoria;
import com.CRUD.estudo.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Optional<Categoria> categoriaSalva = categoriaRepository.findById(codigo);
		if(categoriaSalva == null) {
			
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(codigo, categoriaSalva, "codigo");
		return categoriaRepository.save(categoriaSalva);
		
	}


}
