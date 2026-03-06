package com.example.ejercicio2.mapper;

import com.example.ejercicio2.dto.MascotaCreateUpdateDTO;
import com.example.ejercicio2.dto.MascotaDuenioDTO;
import com.example.ejercicio2.dto.MascotaReadDTO;
import com.example.ejercicio2.model.Mascota;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IMascotaMapper {

    Mascota toCreateUpdateEntity(MascotaCreateUpdateDTO mascotaCreateUpdateDTO);

    MascotaReadDTO toReadDTO(Mascota mascota);

    @Mapping(source = "duenio.nombreDuenio", target = "nombreDuenio")
    @Mapping(source = "duenio.apellido", target = "apellido")
    MascotaDuenioDTO toMascotaDuenioDTO(Mascota mascota);
}
