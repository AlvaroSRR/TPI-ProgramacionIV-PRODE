package com.ProgIV.Prode.features.services.interfaces.prediccion;

import java.util.List;

import com.ProgIV.Prode.features.models.Prediccion;

public interface IPrediccionGetService {

    List<Prediccion> obtenerPredicciones();

    List<Prediccion> obtenerPrediccionesUsuario(Long usuarioId);

    List<Prediccion> obtenerPrediccionesPartido(Long partidoId);

    List<Prediccion> obtenerPrediccionesPorUsuarioYFecha(
        Long usuarioId,
        Long fechaId
    );
}