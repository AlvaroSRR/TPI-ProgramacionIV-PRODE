package com.ProgIV.Prode.features.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record EquipoUpdateRequestDTO(
        @NotBlank String nombre
) {}