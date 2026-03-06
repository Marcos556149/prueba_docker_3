package com.example.ejercicio2.service;

import com.example.ejercicio2.dto.MascotaCreateUpdateDTO;
import com.example.ejercicio2.dto.MascotaDuenioDTO;
import com.example.ejercicio2.dto.MascotaReadDTO;

import java.util.List;

public interface IMascotaService {

    void createMascota(MascotaCreateUpdateDTO mascotaCreateUpdateDTO);

    void updateMascota(Long idMascota,MascotaCreateUpdateDTO mascotaCreateUpdateDTO);

    void deleteMascota(Long idMascota);

    MascotaReadDTO getById(Long idMascota);

    List<MascotaReadDTO> getAll();

    void asociarDuenioAMascota(Long idDuenio,Long idMascota);

    List<MascotaReadDTO> getListado();

    List<MascotaDuenioDTO> getAllMascotasWithDuenio();
}
