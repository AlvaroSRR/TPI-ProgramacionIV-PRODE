package com.ProgIV.Prode.features.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.Prediccion;

public interface PrediccionRepository extends JpaRepository<Prediccion, Long> {
    boolean existsByPartidoId(Long partidoId);

    Optional<Prediccion> findByUsuarioIdAndPartidoId(
            Long usuarioId,
            Long partidoId
    );
    List<Prediccion> findByUsuarioId(Long usuarioId);

    List<Prediccion> findByPartidoId(Long partidoId);
}
