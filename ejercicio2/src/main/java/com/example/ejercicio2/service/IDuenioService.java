package com.example.ejercicio2.service;

import com.example.ejercicio2.dto.DuenioCreateUpdateDTO;
import com.example.ejercicio2.dto.DuenioReadDTO;

import java.util.List;

public interface IDuenioService {


    void createDuenio(DuenioCreateUpdateDTO duenioCreateUpdateDTO);

    void updateDuenio(Long idDuenio,DuenioCreateUpdateDTO duenioCreateUpdateDTO);

    void deleteDuenio(Long idDuenio);

    DuenioReadDTO getById(Long idDuenio);

    List<DuenioReadDTO> getAll();
}
