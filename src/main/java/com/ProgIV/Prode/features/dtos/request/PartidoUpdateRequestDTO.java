package com.ProgIV.Prode.features.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record PartidoUpdateRequestDTO(
    @NotNull Long partidoId,

    @NotNull @Min(0) Integer golLocal,

    @NotNull @Min(0) Integer golVisitante

) {
    
}

