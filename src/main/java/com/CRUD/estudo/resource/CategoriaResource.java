package com.CRUD.estudo.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.estudo.event.RecursoCriadoEvent;
import com.CRUD.estudo.model.Categoria;
import com.CRUD.estudo.repository.CategoriaRepository;
import com.CRUD.estudo.service.CategoriaService;
@CrossOrigin
@RestController
@RequestMapping(path="/categorias",produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaResource {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private CategoriaService categoriaService;


	@GetMapping
	public List<Categoria> listar() {
		
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Optional<Categoria> buscarPeloCodigo(@PathVariable Long codigo){
		
		return categoriaRepository.findById(codigo);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> Criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
	
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo){
		
		categoriaRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria){
		buscarPeloCodigo(codigo);
		
		Categoria categoriaSalva = categoriaService.atualizar(codigo, categoria);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoriaSalva);
	
	}
	

	

	

	
	
	
}