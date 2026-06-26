package com.ProgIV.Prode.features.mappers;

import org.springframework.stereotype.Component;

import com.ProgIV.Prode.features.dtos.response.FechaResponseDTO;
import com.ProgIV.Prode.features.models.Fecha;

@Component
public class FechaMapper {

    public FechaResponseDTO toDTO(Fecha fecha) {
        return new FechaResponseDTO(
                fecha.getId(),
                fecha.getNombre(),
                fecha.getEstado().name()
        );
    }
}
