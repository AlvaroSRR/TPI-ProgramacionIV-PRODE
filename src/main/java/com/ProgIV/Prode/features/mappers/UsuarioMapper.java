package com.ProgIV.Prode.features.mappers;

import org.springframework.stereotype.Component;

import com.ProgIV.Prode.features.dtos.request.UsuarioCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;
import com.ProgIV.Prode.features.models.Usuario;

@Component
public class UsuarioMapper {
    public Usuario toEntity(UsuarioCreateRequestDTO dto, String passwordEncriptada) {

        Usuario usuario = new Usuario();

        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(passwordEncriptada);
        usuario.setRol(dto.getRol());

        return usuario;
    }

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {

        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .email(usuario.getEmail())
                .rol(usuario.getRol().name())
                .idGrupoPropio(usuario.getIdGrupoPropio())
                .build();
    }
}
