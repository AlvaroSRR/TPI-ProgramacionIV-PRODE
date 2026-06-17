package com.ProgIV.Prode.features.mappers;

import org.springframework.stereotype.Component;

import com.ProgIV.Prode.features.dtos.request.EquipoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;
import com.ProgIV.Prode.features.models.Equipo;

@Component
public class EquipoMapper {
    public  Equipo toEntity(EquipoCreateRequestDTO dto) {
        Equipo equipo = new Equipo();
        equipo.setNombre(dto.getNombre());
        return equipo;
    }

    public  EquipoResponseDTO toResponse(Equipo equipo) {
        return new EquipoResponseDTO(
                equipo.getId(),
                equipo.getNombre()
        );
    }
}
