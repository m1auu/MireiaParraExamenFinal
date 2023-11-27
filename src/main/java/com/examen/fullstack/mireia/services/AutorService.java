package com.examen.fullstack.mireia.services;

import java.util.ArrayList;
import java.util.List;

import com.examen.fullstack.mireia.model.AutorDTO;

public interface AutorService {

	AutorDTO crearAutor(AutorDTO autorDTO);

	AutorDTO getAutor(Long id);

	List<AutorDTO> getAllAutor();
    
}
