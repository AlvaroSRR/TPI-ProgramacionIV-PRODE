package com.ProgIV.Prode.features.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.Fecha;

public interface FechaRepository extends JpaRepository<Fecha, Long> {
    boolean existsByNombre(String nombre);
    
}
