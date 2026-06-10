package com.ProgIV.Prode.features.services.interfaces;

import com.ProgIV.Prode.features.dtos.request.UsuarioCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;

public interface IUsuarioService {
    UsuarioResponseDTO create(UsuarioCreateRequestDTO dto);
}
