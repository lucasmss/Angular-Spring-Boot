package com.CRUD.estudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.CRUD.estudo.model.Categoria;
import com.CRUD.estudo.repository.CategoriaRepository;

@Service
@EnableScheduling
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria atualizar (Long codigo, Categoria categoria){

		Long categoriaCod = categoria.getCodigo();
		String nomeCategoria = categoria.getNome();
		
		
		if(categoriaCod == codigo && nomeCategoria != null) {
			
		return categoriaRepository.save(categoria);
		
		}else {
			
			 throw new EmptyResultDataAccessException(1);
		}
		
	}


}
