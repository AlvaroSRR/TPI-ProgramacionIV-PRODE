package com.ProgIV.Prode.features.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EquipoCreateRequestDTO {
    
    @NotBlank (message = "El nombre del equipo es obligatorio")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
