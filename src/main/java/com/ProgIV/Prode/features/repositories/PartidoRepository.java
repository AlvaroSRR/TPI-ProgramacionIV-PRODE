package com.ProgIV.Prode.features.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
    
}
