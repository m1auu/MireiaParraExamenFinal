package com.examen.fullstack.mireia.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.examen.fullstack.mireia.model.AutorDTO;
import com.examen.fullstack.mireia.persistence.entities.AutorEntity;

@Mapper(componentModel = "spring")
public interface AutorMapper {

	AutorDTO autorToDTO (AutorEntity autor);
    AutorEntity autorToEntity (AutorDTO autor);
	List<AutorDTO> listaToDTO(List<AutorEntity> lista);

}
