package com.ProgIV.Prode.features.dtos.response;

import com.ProgIV.Prode.features.models.Equipo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PartidoResponseDTO {
    
    private Long partidoId;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Integer golLocal;
    private Integer golVisitante;
    private String resultado;

}

