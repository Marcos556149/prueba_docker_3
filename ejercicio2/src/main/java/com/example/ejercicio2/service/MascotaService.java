package com.example.ejercicio2.service;

import com.example.ejercicio2.dto.MascotaCreateUpdateDTO;
import com.example.ejercicio2.dto.MascotaDuenioDTO;
import com.example.ejercicio2.dto.MascotaReadDTO;
import com.example.ejercicio2.mapper.IMascotaMapper;
import com.example.ejercicio2.model.Duenio;
import com.example.ejercicio2.model.Mascota;
import com.example.ejercicio2.repository.IDuenioRepository;
import com.example.ejercicio2.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository iMascotaRepository;

    @Autowired
    private IMascotaMapper iMascotaMapper;

    @Autowired
    private IDuenioRepository iDuenioRepository;


    @Override
    public void createMascota(MascotaCreateUpdateDTO mascotaCreateUpdateDTO) {
        Mascota mascota= iMascotaMapper.toCreateUpdateEntity(mascotaCreateUpdateDTO);
        iMascotaRepository.save(mascota);
    }

    @Override
    public void updateMascota(Long idMascota, MascotaCreateUpdateDTO mascotaCreateUpdateDTO) {
        Mascota mascota=iMascotaRepository.findById(idMascota).orElse(null);
        mascota.setNombreMascota(mascotaCreateUpdateDTO.getNombreMascota());
        mascota.setEspecie(mascotaCreateUpdateDTO.getEspecie());
        mascota.setRaza(mascotaCreateUpdateDTO.getRaza());
        mascota.setColor(mascotaCreateUpdateDTO.getColor());

        iMascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long idMascota) {
        iMascotaRepository.deleteById(idMascota);
    }

    @Override
    public MascotaReadDTO getById(Long idMascota) {
        Mascota mascota=iMascotaRepository.findById(idMascota).orElse(null);
        MascotaReadDTO mascotaReadDTO=iMascotaMapper.toReadDTO(mascota);
        return mascotaReadDTO;
    }

    @Override
    public List<MascotaReadDTO> getAll() {
        return iMascotaRepository.findAll().stream()
                .map(iMascotaMapper::toReadDTO)
                .toList();
    }

    @Override
    public void asociarDuenioAMascota(Long idDuenio, Long idMascota) {
        Duenio duenio=iDuenioRepository.findById(idDuenio).orElse(null);
        Mascota mascota=iMascotaRepository.findById(idMascota).orElse(null);

        mascota.setDuenio(duenio);

        iMascotaRepository.save(mascota);
    }

    @Override
    public List<MascotaReadDTO> getListado() {
        return iMascotaRepository.buscarMascotasJava().stream()
                .map(iMascotaMapper::toReadDTO)
                .toList();
    }

    @Override
    public List<MascotaDuenioDTO> getAllMascotasWithDuenio() {
        return iMascotaRepository.findAll().stream()
                .map(iMascotaMapper::toMascotaDuenioDTO)
                .toList();
    }
}
