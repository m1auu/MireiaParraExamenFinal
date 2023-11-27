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
		AutorEntity AutorN = AutorMapper.toEntity(autor);
		AutorEntity GuardarAutor = AutorRepository.save(AutorN);
		return AutorMapper.toDto(GuardarAutor);
	}

	@Override
	public AutorDTO getAutor(Long id) {
		AutorEntity autor = AutorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("El Autor no se ha encontrado"));
		return AutorMapper.toDto(autor);
	}

	@Override
	public List<AutorDTO> getAllAutor() {
		List<AutorEntity> autoresEntity = AutorRepository.findAll();
		List<AutorDTO> autores = new ArrayList<>();
		for (AutorEntity autor : autoresEntity) {
			autores.add(AutorMapper.toDto(autor));
		}
		return autores;
	}

}
