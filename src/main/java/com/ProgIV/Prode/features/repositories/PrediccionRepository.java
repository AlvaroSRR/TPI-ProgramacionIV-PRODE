package com.ProgIV.Prode.features.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ProgIV.Prode.features.dtos.response.RankingResponseDTO;
import com.ProgIV.Prode.features.models.EstadoPartido;
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

    //NUEVO: filtrado por estado
    List<Prediccion> findByPartido_EstadoPartido(EstadoPartido estadoPartido);

    List<Prediccion> findByUsuarioIdAndPartido_EstadoPartido(Long usuarioId, EstadoPartido estadoPartido);

    List<Prediccion> findByPartidoIdAndPartido_EstadoPartido(Long partidoId, EstadoPartido estadoPartido);

    @Query("""
                SELECT new com.ProgIV.Prode.features.dtos.response.RankingResponseDTO(
                    p.usuario.id,
                    p.usuario.nombreUsuario,
                    COALESCE(SUM(p.puntosObtenidos), 0)
                )
                FROM Prediccion p
                WHERE p.partido.estadoPartido = com.ProgIV.Prode.features.models.EstadoPartido.FINALIZADO
                GROUP BY p.usuario.id, p.usuario.nombreUsuario
                ORDER BY SUM(p.puntosObtenidos) DESC
            """)
    List<RankingResponseDTO> obtenerRankingGlobal();

    @Query("""
                SELECT new com.ProgIV.Prode.features.dtos.response.RankingResponseDTO(
                    p.usuario.id,
                    p.usuario.nombreUsuario,
                    COALESCE(SUM(p.puntosObtenidos), 0)
                )
                FROM Prediccion p
                JOIN p.usuario u
                JOIN u.grupos g
                WHERE g.id = :grupoId
                  AND p.partido.estadoPartido = com.ProgIV.Prode.features.models.EstadoPartido.FINALIZADO
                GROUP BY p.usuario.id, p.usuario.nombreUsuario
                ORDER BY COALESCE(SUM(p.puntosObtenidos), 0) DESC
            """)
    List<RankingResponseDTO> obtenerRankingGrupo(@Param("grupoId") Long grupoId);
}