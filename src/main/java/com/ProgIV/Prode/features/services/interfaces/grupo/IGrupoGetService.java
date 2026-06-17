package com.ProgIV.Prode.features.services.interfaces.grupo;

import java.util.List;

import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;

public interface IGrupoGetService {
    List<GrupoResponseDTO> getAll();

    GrupoResponseDTO getById(Long id);
}
