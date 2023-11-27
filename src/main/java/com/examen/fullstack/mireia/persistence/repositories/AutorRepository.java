package com.examen.fullstack.mireia.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.fullstack.mireia.model.AutorDTO;
import com.examen.fullstack.mireia.persistence.entities.AutorEntity;
import com.examen.fullstack.mireia.persistence.entities.LibroEntity;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
	 Optional<AutorDTO> findByNombre(String nombre);
	 List<AutorEntity> findAll();
}
