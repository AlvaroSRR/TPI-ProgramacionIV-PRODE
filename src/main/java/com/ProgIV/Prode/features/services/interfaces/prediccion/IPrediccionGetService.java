package com.ProgIV.Prode.features.services.interfaces.prediccion;

import java.util.List;

import com.ProgIV.Prode.features.dtos.response.PrediccionResponseDTO;

public interface IPrediccionGetService {

    List<PrediccionResponseDTO> obtenerPredicciones();

    List<PrediccionResponseDTO> obtenerPrediccionesUsuario(Long usuarioId);

    List<PrediccionResponseDTO> obtenerPrediccionesPartido(Long partidoId);

    List<PrediccionResponseDTO> obtenerPrediccionesUsuarioYFecha(Long usuarioId, Long fechaId);
}