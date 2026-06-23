package com.ProgIV.Prode.features.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ProgIV.Prode.features.dtos.response.RankingResponseDTO;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.models.Prediccion;
import com.ProgIV.Prode.features.models.Usuario;


public interface PrediccionRepository extends JpaRepository<Prediccion, Long> {
    boolean existsByPartidoId(Long partidoId);

    Optional<Prediccion> findByUsuarioAndPartido(Usuario usuario, Partido partido);

    List<Prediccion> findByUsuarioId(Long usuarioId);

    List<Prediccion> findByPartidoId(Long partidoId);

    List<Prediccion> findByPartido(Partido partido);

    List<Prediccion> findByUsuarioIdAndPartidoFechaId(Long usuarioId, Long fechaId);

    @Query("""
                SELECT new com.ProgIV.Prode.features.dtos.response.RankingResponseDTO(
                    p.usuario.id,
                    p.usuario.nombreUsuario,
                    COALESCE(SUM(p.puntosObtenidos), 0)
                )
                FROM Prediccion p
                GROUP BY p.usuario.id, p.usuario.nombreUsuario
                ORDER BY SUM(p.puntosObtenidos) DESC
            """)
    List<RankingResponseDTO> obtenerRankingGlobal();
}