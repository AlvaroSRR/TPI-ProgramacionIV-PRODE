package com.ProgIV.Prode.features.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    boolean existsByNombre(String nombre);

    List<Equipo> findByEliminadoFalse();

    Optional<Equipo> findByIdAndEliminadoFalse(Long id);
}
