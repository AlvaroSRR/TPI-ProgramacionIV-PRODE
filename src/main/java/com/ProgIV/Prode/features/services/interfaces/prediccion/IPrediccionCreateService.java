package com.ProgIV.Prode.features.services.interfaces.prediccion;

import com.ProgIV.Prode.features.dtos.request.PrediccionCreateRequestDTO;
import com.ProgIV.Prode.features.models.Prediccion;

public interface IPrediccionCreateService {

    Prediccion guardarPrediccion(PrediccionCreateRequestDTO dto);

}