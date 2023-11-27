package com.examen.fullstack.mireia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.fullstack.mireia.mappers.AutorMapper;
import com.examen.fullstack.mireia.model.AutorDTO;
import com.examen.fullstack.mireia.persistence.entities.AutorEntity;
import com.examen.fullstack.mireia.persistence.repositories.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    AutorRepository AutorRepository;
    @Autowired 
    AutorMapper AutorMapper;
    @Override
    public AutorDTO crearAutor(AutorDTO autor) {
         AutorEntity AutorN = AutorMapper.autorToEntity(autor);
         AutorEntity GuardarAutor = AutorRepository.save(AutorN);
         return AutorMapper.autorToDTO(GuardarAutor);
    }

    @Override
    public ArrayList<AutorDTO> verAutores() {
        List<AutorEntity> lista = AutorRepository.findAll();
        List<AutorDTO> autores = AutorMapper.listaToDTO(lista);

        return (ArrayList<AutorDTO>) autores;
    

    }

}
