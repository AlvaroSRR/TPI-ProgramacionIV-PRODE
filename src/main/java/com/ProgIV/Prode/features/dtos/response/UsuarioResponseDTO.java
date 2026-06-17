package com.ProgIV.Prode.features.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UsuarioResponseDTO {
    private Long id;
    private String nombreUsuario;
    private String email;
    private String rol;
    private Long idGrupoPropio;

}
