package com.ProgIV.Prode.features.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.models.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findByFechaIdOrderByHoraInicioAsc(Long fechaId);

    List<Partido> findByFecha(Fecha fecha);
    
    List<Partido> findByEliminadoFalse();
}
