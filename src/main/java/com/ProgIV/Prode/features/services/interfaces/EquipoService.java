package com.ProgIV.Prode.features.services.interfaces;

import com.ProgIV.Prode.features.dtos.request.CreateEquipoRequest;
import com.ProgIV.Prode.features.dtos.response.EquipoResponse;

public interface EquipoService {
    EquipoResponse crearEquipo(CreateEquipoRequest request);
}
