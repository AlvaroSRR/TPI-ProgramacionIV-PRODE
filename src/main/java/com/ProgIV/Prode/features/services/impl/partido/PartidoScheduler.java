package com.ProgIV.Prode.features.services.impl.partido;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.repositories.PartidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoScheduler {

    private final PartidoRepository partidoRepository;


    @Scheduled(fixedRate = 60000) // cada 60 segundos
    public void actualizarEstadosPartidos() {

        OffsetDateTime ahora = OffsetDateTime.now();

        List<Partido> partidos = partidoRepository
        .findByEstadoPartidoAndHoraInicioLessThanEqual(
            EstadoPartido.POR_JUGARSE,
            ahora
        );

        for (Partido partido : partidos) {

            partido.setEstadoPartido(EstadoPartido.EN_JUEGO);
            if (partido.getGolLocal() == null) {
                partido.setGolLocal(0);
            }

            if (partido.getGolVisitante() == null) {
                partido.setGolVisitante(0);
            }
        }

        partidoRepository.saveAll(partidos);
    }
}