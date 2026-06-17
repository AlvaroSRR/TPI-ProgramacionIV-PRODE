package com.ProgIV.Prode.features.services.interfaces.equipo;

import com.ProgIV.Prode.features.dtos.request.EquipoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;

public interface IEquipoCreateService {
    EquipoResponseDTO crearEquipo(EquipoCreateRequestDTO request);

}
