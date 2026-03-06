package com.example.ejercicio2.mapper;

import com.example.ejercicio2.dto.DuenioCreateUpdateDTO;
import com.example.ejercicio2.dto.DuenioReadDTO;
import com.example.ejercicio2.model.Duenio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDuenioMapper {

    Duenio toCreateUpdateEntity(DuenioCreateUpdateDTO duenioCreateUpdateDTO);

    DuenioReadDTO toReadDTO(Duenio duenio);



}
