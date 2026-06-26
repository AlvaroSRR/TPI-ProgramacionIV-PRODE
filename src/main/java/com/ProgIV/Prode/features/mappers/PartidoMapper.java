package com.ProgIV.Prode.features.mappers;

import org.springframework.stereotype.Component;

import com.ProgIV.Prode.features.dtos.response.PartidoResponseDTO;
import com.ProgIV.Prode.features.models.Partido;

@Component
public class PartidoMapper {

     public PartidoResponseDTO toDTO(Partido p) {

        return PartidoResponseDTO.builder()
                .partidoId(p.getId())
                .equipoLocal(p.getEquipoLocal().getNombre())
                .equipoVisitante(p.getEquipoVisitante().getNombre())
                .golLocal(p.getGolLocal())
                .golVisitante(p.getGolVisitante())
                .resultado(p.getResultado())
                .estado(p.getEstadoPartido().name())
                .fecha(p.getFecha().getNombre())
                .horaInicio(p.getHoraInicio() != null ? p.getHoraInicio().toString() : null)
                .build();
    }
}