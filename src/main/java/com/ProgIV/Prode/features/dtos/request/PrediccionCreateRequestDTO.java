package com.ProgIV.Prode.features.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PrediccionCreateRequestDTO {

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long partidoId;


    @NotNull
    private Integer golLocal;

    @NotNull
    private Integer golVisitante;

}
