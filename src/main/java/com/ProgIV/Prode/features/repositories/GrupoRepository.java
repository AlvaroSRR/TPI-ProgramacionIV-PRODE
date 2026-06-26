package com.ProgIV.Prode.features.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ProgIV.Prode.features.models.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    boolean existsByNombre(String nombre);

    Optional<Grupo> findByCodigoInvitacion(String codigoInvitacion);

    List<Grupo> findByActivoTrue();

    Optional<Grupo> findByIdAndActivoTrue(Long id);

    @Query("SELECT g FROM Grupo g LEFT JOIN FETCH g.usuarios WHERE g.activo = true")
    List<Grupo> findByActivoTrueWithUsuarios();

    @Query("SELECT g FROM Grupo g LEFT JOIN FETCH g.usuarios WHERE g.id = :id AND g.activo = true")
    Optional<Grupo> findByIdAndActivoTrueWithUsuarios(@Param("id") Long id);
}
