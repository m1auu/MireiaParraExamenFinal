package com.examen.fullstack.mireia.services;

import java.util.ArrayList;
import com.examen.fullstack.mireia.model.AutorDTO;

public interface AutorService {

	AutorDTO crearAutor(AutorDTO autorDTO);

	ArrayList<AutorDTO> verAutores();
    
}
