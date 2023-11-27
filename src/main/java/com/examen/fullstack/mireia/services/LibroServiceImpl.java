package com.examen.fullstack.mireia.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.fullstack.mireia.exceptions.AutorNotFoundException;
import com.examen.fullstack.mireia.mappers.LibroMapper;
import com.examen.fullstack.mireia.model.LibroDTO;
import com.examen.fullstack.mireia.persistence.entities.AutorEntity;
import com.examen.fullstack.mireia.persistence.entities.LibroEntity;
import com.examen.fullstack.mireia.persistence.repositories.AutorRepository;
import com.examen.fullstack.mireia.persistence.repositories.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

		@Autowired
		LibroRepository libroRepository;
		@Autowired
		LibroMapper libroMapper;
		@Autowired
		AutorRepository autorRepository;

		@Override
		public LibroDTO crearLibro(LibroDTO libroDTO) {

			LibroEntity Libro = libroMapper.toEntity(libroDTO);

			if (libroDTO.getAutorId() != null) {
				AutorEntity Autor = autorRepository.findById(libroDTO.getAutorId())
						.orElseThrow(() -> new AutorNotFoundException("El Autor no se ha encontrado en la base de datos."));

				Libro.setAutor(Autor);
			}

			Libro = libroRepository.save(Libro);
			return libroMapper.toDto(Libro);
		}

	

	@Override
	 public LibroDTO obtenerLibro(Long id) {
        LibroEntity libroEntity = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
        return libroMapper.toDto(libroEntity);
	}
	
	@Override
	public List<LibroDTO> obtenerTodosLosLibros() {
        List<LibroEntity> libros = libroRepository.findAll();
        return libros.stream()
                .map(libroMapper::toDto)
                .collect(Collectors.toList());
    }


}
