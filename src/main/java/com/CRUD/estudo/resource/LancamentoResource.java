package com.CRUD.estudo.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.estudo.event.RecursoCriadoEvent;
import com.CRUD.estudo.model.Lancamento;
import com.CRUD.estudo.repository.LancamentoRepository;
import com.CRUD.estudo.repository.filter.LancamentoFilter;
import com.CRUD.estudo.service.LancamentoService;


@RestController
@RequestMapping(path="/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	
	@GetMapping
	public List<Lancamento> listarLancamento(LancamentoFilter lancamentoFilter){
		
		return lancamentoRepository.filtrar(lancamentoFilter); 
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Lancamento>> buscarPeloCodigo(@PathVariable Long codigo) {
		
		Optional<Lancamento> lancamentoCod = lancamentoRepository.findById(codigo);
		
		if(lancamentoCod != null) {
			
		return ResponseEntity.ok(lancamentoCod);
				
		}else {
			
		return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Lancamento> criarLancamento(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) throws Exception {
		
		Lancamento lancamentoNovo = lancamentoService.salvar(lancamento);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoNovo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoNovo);
	}
	
	
}
