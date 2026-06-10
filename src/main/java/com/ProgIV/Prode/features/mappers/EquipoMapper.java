package com.ProgIV.Prode.features.mappers;

import com.ProgIV.Prode.features.dtos.request.EquipoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;
import com.ProgIV.Prode.features.models.Equipo;

public class EquipoMapper {
    public static Equipo toEntity(EquipoCreateRequestDTO dto) {
        Equipo equipo = new Equipo();
        equipo.setNombre(dto.getNombre());
        return equipo;
    }

    public static EquipoResponseDTO toResponse(Equipo equipo) {
        return new EquipoResponseDTO(
                equipo.getId(),
                equipo.getNombre()
        );
    }
}
