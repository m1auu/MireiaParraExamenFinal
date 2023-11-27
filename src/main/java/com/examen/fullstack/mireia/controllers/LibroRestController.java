package com.examen.fullstack.mireia.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examen.fullstack.mireia.model.LibroDTO;
import com.examen.fullstack.mireia.services.LibroService;


@RestController
@RequestMapping("/libros")
public class LibroRestController {
	
	@Autowired
	LibroService libroService;
	
	@PostMapping()
	public ResponseEntity<?> crearLibro(@RequestBody @Validated LibroDTO libro){
		
		libroService.crearLibro(libro);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(libro.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();		
		
	}
	

	
}
