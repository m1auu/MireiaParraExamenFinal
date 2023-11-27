package com.examen.fullstack.mireia.services;

import java.util.List;

import com.examen.fullstack.mireia.model.LibroDTO;

public interface LibroService {

	LibroDTO crearLibro(LibroDTO libroDTO);
	
	LibroDTO obtenerLibro(Long id);

	public List<LibroDTO> obtenerTodosLosLibros();
	

}
