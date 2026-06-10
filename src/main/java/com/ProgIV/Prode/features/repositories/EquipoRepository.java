package com.ProgIV.Prode.features.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    boolean existsByNombre(String nombre);
}
