package com.ProgIV.Prode.features.services.interfaces.grupo;

import com.ProgIV.Prode.features.dtos.request.GrupoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;

public interface IGrupoCreateService {
    GrupoResponseDTO create(GrupoCreateRequestDTO dto);
}
