package com.examen.fullstack.mireia.mappers;

import org.mapstruct.Mapper;

import com.examen.fullstack.mireia.model.AutorDTO;
import com.examen.fullstack.mireia.persistence.entities.AutorEntity;

@Mapper(componentModel = "spring", uses = { LibroMapper.class })
public interface AutorMapper {

	AutorDTO toDto(AutorEntity autor);

	AutorEntity toEntity(AutorDTO autorDTO);
}
