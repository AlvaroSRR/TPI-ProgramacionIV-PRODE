package com.ProgIV.Prode.features.dtos.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PartidoResponseDTO {

    private Long partidoId;
    private String equipoLocal;
    private String equipoVisitante;
    private Integer golLocal;
    private Integer golVisitante;
    private String resultado;
    private String estado;
    private String fecha;
    private String horaInicio;

}
