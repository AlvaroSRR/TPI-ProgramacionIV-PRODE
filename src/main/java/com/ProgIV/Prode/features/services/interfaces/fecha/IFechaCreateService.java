package com.ProgIV.Prode.features.services.interfaces.fecha;

import com.ProgIV.Prode.features.dtos.request.FechaCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.FechaResponseDTO;

public interface IFechaCreateService {

    FechaResponseDTO crearFecha(FechaCreateRequestDTO dto);
}
