package com.ProgIV.Prode.features.services.interfaces.partido;

import com.ProgIV.Prode.features.dtos.request.PartidoCreateRequestDTO;
import com.ProgIV.Prode.features.models.Partido;

public interface IPartidoCreateService {
    Partido crearPartido(PartidoCreateRequestDTO dto);
}
