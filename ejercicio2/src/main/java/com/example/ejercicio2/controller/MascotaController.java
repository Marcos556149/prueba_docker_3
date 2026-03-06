package com.example.ejercicio2.controller;

import com.example.ejercicio2.dto.MascotaCreateUpdateDTO;
import com.example.ejercicio2.dto.MascotaDuenioDTO;
import com.example.ejercicio2.dto.MascotaReadDTO;
import com.example.ejercicio2.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService iMascotaService;

    @PostMapping("/mascotas")
    public String createMascota(@RequestBody MascotaCreateUpdateDTO mascotaCreateUpdateDTO){
        iMascotaService.createMascota(mascotaCreateUpdateDTO);
        return "La mascota fue creada correctamente";
    }

    @PutMapping("/mascotas/{idMascota}")
    public String updateMascota(@PathVariable Long idMascota,@RequestBody MascotaCreateUpdateDTO mascotaCreateUpdateDTO){
        iMascotaService.updateMascota(idMascota,mascotaCreateUpdateDTO);
        return "La mascota fue modificada correctamente";

    }

    @DeleteMapping("/mascotas/{idMascota}")
    public String deleteMascota(@PathVariable Long idMascota){
        iMascotaService.deleteMascota(idMascota);
        return "La mascota fue eliminada correctamente";
    }

    @GetMapping("/mascotas/{idMascota}")
    public MascotaReadDTO getById(@PathVariable Long idMascota){
        return iMascotaService.getById(idMascota);
    }

    @GetMapping("/mascotas")
    public List<MascotaReadDTO> getAll(){
        return iMascotaService.getAll();
    }

    @PutMapping("/mascotas/{idDuenio}/{idMascota}")
    public String asociarDuenioAMascota(@PathVariable Long idDuenio, @PathVariable Long idMascota){
        iMascotaService.asociarDuenioAMascota(idDuenio,idMascota);
        return "El dueño con id "+idDuenio+" fue asociado correctamente a la mascota con id "+idMascota;
    }

    @GetMapping("/mascotas/listado")
    public List<MascotaReadDTO> getListado(){
        return iMascotaService.getListado();
    }

    @GetMapping("/mascotas/duenio")
    public List<MascotaDuenioDTO> getAllMascotasWithDuenio(){
        return iMascotaService.getAllMascotasWithDuenio();
    }
}
