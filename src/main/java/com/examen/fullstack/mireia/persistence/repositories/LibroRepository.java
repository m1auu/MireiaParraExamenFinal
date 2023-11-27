package com.examen.fullstack.mireia.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.fullstack.mireia.persistence.entities.LibroEntity;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
	List<LibroEntity> findAll();
}
