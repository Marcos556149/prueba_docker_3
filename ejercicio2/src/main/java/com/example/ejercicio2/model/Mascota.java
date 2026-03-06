package com.example.ejercicio2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mascota",schema = "ejercicio_2")
@SequenceGenerator(name = "mascota_seq",
                   sequenceName = "ejercicio_2.mascota_seq",
                   allocationSize = 1)
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "mascota_seq")
    @Column(name = "id_mascota")
    private Long idMascota;

    @Column(name = "nombre_mascota")
    private String nombreMascota;

    private String especie;
    private String raza;
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_duenio")
    private Duenio duenio;

}
