package com.example.ejercicio2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "duenio",schema = "ejercicio_2")
@SequenceGenerator(name = "duenio_seq",
                   sequenceName = "ejercicio_2.duenio_seq",
                   allocationSize = 1)
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "duenio_seq")
    @Column(name = "id_duenio")
    private Long idDuenio;

    private String dni;

    @Column(name = "nombre_duenio")
    private String nombreDuenio;
    private String apellido;
    private String celular;

    @OneToMany(mappedBy = "duenio")
    private List<Mascota> listaMascotas;
}
