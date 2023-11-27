package com.examen.fullstack.mireia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.examen.fullstack.mireia.model.LibroDTO;
import com.examen.fullstack.mireia.persistence.entities.AutorEntity;
import com.examen.fullstack.mireia.persistence.entities.LibroEntity;

@Mapper(componentModel = "spring")
public interface LibroMapper {
	@Mapping(source = "autor", target = "autorId", qualifiedByName = "mapAutorId")
    LibroDTO toDto(LibroEntity libro);
    LibroEntity toEntity(LibroDTO libroDTO);
    
    @Named("mapAutorId")
    default Long mapAutorId(AutorEntity autor) {
        if (autor == null) {
            return null;
        }
        return autor.getId();
    }
}
