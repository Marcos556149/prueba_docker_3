package com.example.ejercicio2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MascotaCreateUpdateDTO {
    private String nombreMascota;
    private String especie;
    private String raza;
    private String color;
}
