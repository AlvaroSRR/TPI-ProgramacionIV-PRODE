package com.ProgIV.Prode.features.services.interfaces.partido;

import com.ProgIV.Prode.features.dtos.request.PartidoUpdateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.PartidoResponseDTO;

public interface IPartidoUpdateService {
    
    PartidoResponseDTO actualizarResultado(PartidoUpdateRequestDTO dto);
}