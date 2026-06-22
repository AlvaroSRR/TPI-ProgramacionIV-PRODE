package com.ProgIV.Prode.features.services.interfaces.partido;

import com.ProgIV.Prode.features.dtos.request.PartidoUpdateRequestDTO;
import com.ProgIV.Prode.features.models.Partido;

public interface IPartidoUpdateService {
    
    Partido actualizarResultado(PartidoUpdateRequestDTO dto);
}
