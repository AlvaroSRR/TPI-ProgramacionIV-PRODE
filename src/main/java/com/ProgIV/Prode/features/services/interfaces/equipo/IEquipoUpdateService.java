package com.ProgIV.Prode.features.services.interfaces.equipo;

import com.ProgIV.Prode.features.dtos.request.EquipoUpdateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;

public interface IEquipoUpdateService {
    EquipoResponseDTO update(Long id, EquipoUpdateRequestDTO dto);
}
