package com.examen.fullstack.mireia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.examen.fullstack.mireia.model.LibroDTO;
import com.examen.fullstack.mireia.persistence.entities.LibroEntity;

@Mapper(componentModel = "spring", uses = {AutorMapper.class})
public interface LibroMapper {

    LibroDTO toDto(LibroEntity libro);
    LibroEntity toEntity(LibroDTO libroDTO);
    
    @Mapping(target = "autorId", ignore = true)
    LibroDTO toDtoWithoutLibroDTO(LibroEntity libro);
}
