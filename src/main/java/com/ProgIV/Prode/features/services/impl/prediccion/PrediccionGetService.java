package com.ProgIV.Prode.features.services.impl.prediccion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Prediccion;
import com.ProgIV.Prode.features.repositories.PrediccionRepository;
import com.ProgIV.Prode.features.services.interfaces.prediccion.IPrediccionGetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrediccionGetService implements IPrediccionGetService {


    private final PrediccionRepository prediccionRepository;


    @Override
    public List<Prediccion> obtenerPredicciones() {

        return prediccionRepository.findAll();


    }
  @Override
    public List<Prediccion> obtenerPrediccionesUsuario(Long usuarioId) {

        return prediccionRepository.findByUsuarioId(usuarioId);

    }


    @Override
    public List<Prediccion> obtenerPrediccionesPartido(Long partidoId) {

        return prediccionRepository.findByPartidoId(partidoId);

    }
}