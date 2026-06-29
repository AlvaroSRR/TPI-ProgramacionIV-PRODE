package com.ProgIV.Prode.features.services.interfaces.partido;

import com.ProgIV.Prode.features.dtos.request.PartidoUpdateDatosRequestDTO;
import com.ProgIV.Prode.features.models.Partido;

public interface IPartidoUpdateService {
    
    // Partido actualizarResultado(PartidoUpdateRequestDTO dto);
    Partido actualizar(Long id, PartidoUpdateDatosRequestDTO dto);
}
