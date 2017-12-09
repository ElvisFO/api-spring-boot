package com.example.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.model.Lancamento;
import com.example.api.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@GetMapping
	public List<Lancamento> findAll()
	{
		return lancamentoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response)
	{
		Lancamento lancamentoSalvo = lancamentoRepository.save(lancamento);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(lancamentoSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(lancamentoSalvo);
	}
	
	@GetMapping("/{codigo}")
	public Lancamento findOne(@PathVariable Long codigo) {
		return lancamentoRepository.findOne(codigo);
	}
}
