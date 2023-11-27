package com.examen.fullstack.mireia.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examen.fullstack.mireia.model.AutorDTO;
import com.examen.fullstack.mireia.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorRestController {

	@Autowired
	AutorService autorService;

	@PostMapping
	ResponseEntity<?> crearAutor(@RequestBody AutorDTO autorDTO) {

		autorService.crearAutor(autorDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + autorDTO.getId())
				.buildAndExpand(autorDTO.getId()).toUri();

		return ResponseEntity.created(location).build();


		
	
	}
}
