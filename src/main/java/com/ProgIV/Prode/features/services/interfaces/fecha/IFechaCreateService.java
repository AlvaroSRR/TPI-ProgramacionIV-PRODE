package com.ProgIV.Prode.features.services.interfaces.fecha;

import com.ProgIV.Prode.features.dtos.request.FechaCreateRequestDTO;
import com.ProgIV.Prode.features.models.Fecha;

public interface IFechaCreateService {

    Fecha crearFecha(FechaCreateRequestDTO dto);
}
