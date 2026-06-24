package com.ProgIV.Prode.features.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FechaUpdateDTO {

    @NotBlank(message = "El nombre de la fecha es obligatorio")
    private String nombre;

}