package com.ProgIV.Prode.features.dtos.response;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrediccionResponseDTO {

    private Long id;

    private String nombreUsuario;

    private Long partidoId;

    private String estadoPartido;

    private Integer golLocal;

    private Integer golVisitante;

    private Integer puntosObtenidos;

    private Boolean esTendencia;

    private Boolean esExacta;

    private OffsetDateTime fechaPrediccion;
}