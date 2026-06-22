package com.ProgIV.Prode.features.repositories;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.models.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findByFechaIdOrderByHoraInicioAsc(Long fechaId);

    List<Partido> findByFecha(Fecha fecha);
    
    List<Partido> findByEliminadoFalse();
        List<Partido> findByEstadoPartidoAndHoraInicioLessThanEqual(
            EstadoPartido estadoPartido,
            OffsetDateTime horaInicio
    );

}
