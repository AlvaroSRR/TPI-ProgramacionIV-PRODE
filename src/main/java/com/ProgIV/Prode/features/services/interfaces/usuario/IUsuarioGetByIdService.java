package com.ProgIV.Prode.features.services.interfaces.usuario;

import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;

public interface IUsuarioGetByIdService {
    UsuarioResponseDTO execute(Long id);
}
