package com.ProgIV.Prode.features.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.Prediccion;

public interface PrediccionRepository extends JpaRepository<Prediccion, Long> {
    
}
