package com.ProgIV.Prode.features.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.Fecha;

public interface FechaRepository extends JpaRepository<Fecha, Long> {
    boolean existsByNombre(String nombre);
    
    Optional<Fecha> findByIdAndEliminadoFalse(Long id);
}
