package com.ProgIV.Prode.features.services.interfaces.usuario;

import org.springframework.security.core.Authentication;

import com.ProgIV.Prode.features.dtos.request.UsuarioUpdateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;

public interface IUsuarioUpdateService {
        UsuarioResponseDTO update(Long id, UsuarioUpdateRequestDTO dto, Authentication authentication);
}
