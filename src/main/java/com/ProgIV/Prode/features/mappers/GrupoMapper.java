package com.ProgIV.Prode.features.mappers;

import org.springframework.stereotype.Component;

import com.ProgIV.Prode.features.dtos.request.GrupoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;
import com.ProgIV.Prode.features.models.Grupo;

@Component
public class GrupoMapper {

    public Grupo toEntity(
            GrupoCreateRequestDTO dto,
            String codigoInvitacion) {

        Grupo grupo = new Grupo();

        grupo.setNombre(dto.getNombre());
        grupo.setCodigoInvitacion(codigoInvitacion);
        grupo.setActivo(true);

        return grupo;
    }

    public GrupoResponseDTO toResponseDTO(Grupo grupo) {

        return GrupoResponseDTO.builder()
                .id(grupo.getId())
                .nombre(grupo.getNombre())
                .codigoInvitacion(grupo.getCodigoInvitacion())
                .cantidadUsuarios(grupo.getUsuarios().size())
                .activo(grupo.getActivo())
                .build();
    }
}