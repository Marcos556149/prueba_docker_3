package com.example.ejercicio2.repository;

import com.example.ejercicio2.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuenioRepository extends JpaRepository<Duenio,Long> {
}
