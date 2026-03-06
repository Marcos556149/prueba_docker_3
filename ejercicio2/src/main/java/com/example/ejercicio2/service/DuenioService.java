package com.example.ejercicio2.service;

import com.example.ejercicio2.dto.DuenioCreateUpdateDTO;
import com.example.ejercicio2.dto.DuenioReadDTO;
import com.example.ejercicio2.mapper.IDuenioMapper;
import com.example.ejercicio2.model.Duenio;
import com.example.ejercicio2.repository.IDuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService implements IDuenioService{

    @Autowired
    private IDuenioRepository iDuenioRepository;

    @Autowired
    private IDuenioMapper iDuenioMapper;

    @Override
    public void createDuenio(DuenioCreateUpdateDTO duenioCreateUpdateDTO) {
        Duenio duenio=iDuenioMapper.toCreateUpdateEntity(duenioCreateUpdateDTO);
        iDuenioRepository.save(duenio);
    }

    @Override
    public void updateDuenio(Long idDuenio, DuenioCreateUpdateDTO duenioCreateUpdateDTO) {
        Duenio duenio=iDuenioRepository.findById(idDuenio).orElse(null);
        duenio.setDni(duenioCreateUpdateDTO.getDni());
        duenio.setNombreDuenio(duenioCreateUpdateDTO.getNombreDuenio());
        duenio.setApellido(duenioCreateUpdateDTO.getApellido());
        duenio.setCelular(duenioCreateUpdateDTO.getCelular());

        iDuenioRepository.save(duenio);


    }

    @Override
    public void deleteDuenio(Long idDuenio) {
        iDuenioRepository.deleteById(idDuenio);
    }

    @Override
    public DuenioReadDTO getById(Long idDuenio) {
        Duenio duenio=iDuenioRepository.findById(idDuenio).orElse(null);
        DuenioReadDTO duenioReadDTO=iDuenioMapper.toReadDTO(duenio);
        return duenioReadDTO;
    }

    @Override
    public List<DuenioReadDTO> getAll() {
        return iDuenioRepository.findAll().stream()
                .map(iDuenioMapper::toReadDTO)
                .toList();
    }
}
