package com.dimaz.livrariaapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dimaz.livrariaapi.domain.dtos.LivroDTO;
import com.dimaz.livrariaapi.services.LivroService;

@RestController
@RequestMapping("/v1/livros")
public class LivroController {

	@Autowired
	LivroService service;
	
	//cria
	@PostMapping
	public ResponseEntity<LivroDTO> save(@RequestBody LivroDTO livroDto) throws Exception {
		try {
			livroDto = service.save(livroDto);
			return ResponseEntity.ok(livroDto);
		} catch (Exception e) { }
		return ResponseEntity.badRequest().build();		
	}
	
	//altera
	@PatchMapping("{id}")
	public ResponseEntity<LivroDTO> update(@PathVariable("id") Long id) throws Exception {
		return (service.findById(id) != null) ? ResponseEntity.ok(service.patch(id)) : ResponseEntity.notFound().build();
	}
	
//	deleta
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception {
		return (service.findById(id) != null) ? ResponseEntity.ok(service.delete(id).toString()) : ResponseEntity.notFound().build();
	}
	
	//buscas
	@GetMapping("{id}")
	public ResponseEntity<LivroDTO> find(@PathVariable("id") Long id) throws Exception {
		return (service.findById(id) != null) ? ResponseEntity.ok(service.findById(id)) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@Valid LivroDTO filter) throws Exception {
		return ResponseEntity.ok(service.findAll(filter));
	}
	
	
}
