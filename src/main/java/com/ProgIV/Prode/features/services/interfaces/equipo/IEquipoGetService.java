package com.ProgIV.Prode.features.services.interfaces.equipo;

import java.util.List;

import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;

public interface IEquipoGetService {

    List<EquipoResponseDTO> getAll();

    EquipoResponseDTO getById(Long id);
}