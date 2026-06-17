package com.ProgIV.Prode.features.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FechaCreateRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
}