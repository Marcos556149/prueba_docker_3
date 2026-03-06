package com.example.ejercicio2.controller;

import com.example.ejercicio2.dto.DuenioCreateUpdateDTO;
import com.example.ejercicio2.dto.DuenioReadDTO;
import com.example.ejercicio2.service.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DuenioController {

    @Autowired
    private IDuenioService iDuenioService;

    @PostMapping("/duenios")
    public String createDuenio(@RequestBody DuenioCreateUpdateDTO duenioCreateUpdateDTO){
        iDuenioService.createDuenio(duenioCreateUpdateDTO);
        return "El dueño fue creado correctamente";
    }

    @PutMapping("/duenios/{idDuenio}")
    public String updateDuenio(@PathVariable Long idDuenio,@RequestBody DuenioCreateUpdateDTO duenioCreateUpdateDTO){
        iDuenioService.updateDuenio(idDuenio,duenioCreateUpdateDTO);
        return "El dueño ha sido modificado correctamente";
    }

    @DeleteMapping("/duenios/{idDuenio}")
    public String deleteDuenio(@PathVariable Long idDuenio){
        iDuenioService.deleteDuenio(idDuenio);
        return "El dueño fue eliminado correctamente";
    }

    @GetMapping("/duenios/{idDuenio}")
    public DuenioReadDTO getById(@PathVariable Long idDuenio){
        return iDuenioService.getById(idDuenio);
    }

    @GetMapping("/duenios")
    public List<DuenioReadDTO> getAll(){
        return iDuenioService.getAll();
    }
}
