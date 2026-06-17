package com.ProgIV.Prode.features.services.interfaces.partido;

import java.util.List;

import com.ProgIV.Prode.features.models.Partido;

public interface IPartidoGetService {

    List<Partido> listarPartidos(Long fechaId);
}
