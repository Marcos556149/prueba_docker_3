package com.example.ejercicio2.repository;

import com.example.ejercicio2.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota,Long> {

    @Query(value = "SELECT * FROM ejercicio_2.mascota WHERE especie ILIKE 'perro' AND raza ILIKE 'caniche'",nativeQuery = true)
    List<Mascota> buscarMascotasJava();
}
