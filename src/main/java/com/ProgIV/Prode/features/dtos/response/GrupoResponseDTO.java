package com.ProgIV.Prode.features.dtos.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GrupoResponseDTO {

    private Long id;
    private String nombre;
    private String codigoInvitacion;
    private Integer cantidadUsuarios;
}