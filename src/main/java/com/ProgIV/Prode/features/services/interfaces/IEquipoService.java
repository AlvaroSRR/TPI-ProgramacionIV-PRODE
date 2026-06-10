package com.ProgIV.Prode.features.services.interfaces;

import com.ProgIV.Prode.features.dtos.request.EquipoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;

public interface IEquipoService {
    EquipoResponseDTO crearEquipo(EquipoCreateRequestDTO request);

}
