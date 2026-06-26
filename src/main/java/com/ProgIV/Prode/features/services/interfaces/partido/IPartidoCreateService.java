package com.ProgIV.Prode.features.services.interfaces.partido;

import com.ProgIV.Prode.features.dtos.request.PartidoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.PartidoResponseDTO;

public interface IPartidoCreateService {
     PartidoResponseDTO crearPartido(PartidoCreateRequestDTO dto);
}
