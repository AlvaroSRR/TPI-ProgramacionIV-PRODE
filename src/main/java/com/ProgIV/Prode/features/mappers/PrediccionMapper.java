package com.ProgIV.Prode.features.mappers;

import org.springframework.stereotype.Component;

import com.ProgIV.Prode.features.dtos.response.PrediccionResponseDTO;
import com.ProgIV.Prode.features.models.Prediccion;

@Component
public class PrediccionMapper {

    public PrediccionResponseDTO toDTO(Prediccion p) {
        return new PrediccionResponseDTO(
                p.getId(),
                p.getUsuario().getId(),
                p.getPartido().getId(),
                p.getGolLocal(),
                p.getGolVisitante(),
                p.getPuntosObtenidos(),
                p.getFechaPrediccion()
        );
    }
}
