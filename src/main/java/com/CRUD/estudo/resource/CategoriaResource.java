package com.CRUD.estudo.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CRUD.estudo.model.Categoria;
import com.CRUD.estudo.repository.CategoriaRepository;

@RestController
@RequestMapping(path="/categorias",produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaResource {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar() {
		
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> Criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/codigo}")
				.buildAndExpand(categoriaSalva.getCodigo()).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(categoriaSalva);
	}
	
	
	
	
}