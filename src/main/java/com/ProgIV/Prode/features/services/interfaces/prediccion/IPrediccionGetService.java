package com.ProgIV.Prode.features.services.interfaces.prediccion;

import java.util.List;

import com.ProgIV.Prode.features.dtos.response.PrediccionResponseDTO;
import com.ProgIV.Prode.features.models.EstadoPartido;

public interface IPrediccionGetService {

    List<PrediccionResponseDTO> obtenerPredicciones(EstadoPartido estado);
    List<PrediccionResponseDTO> obtenerPrediccionesUsuario(Long usuarioId);

    List<PrediccionResponseDTO> obtenerPrediccionesPartido(Long partidoId);

    List<PrediccionResponseDTO> obtenerPrediccionesUsuarioYFecha(Long usuarioId, Long fechaId);
}