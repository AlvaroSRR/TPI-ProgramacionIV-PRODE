package com.ProgIV.Prode.features.dtos.response;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingResponseDTO {
    
    private Long usuarioId;
    private String usuarioNombre;
    private Long puntos;
    private Long exactas;
    private OffsetDateTime primeraPrediccion;
}
