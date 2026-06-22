package com.ProgIV.Prode.features.services.impl.prediccion;

import java.util.*;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.models.Prediccion;
import com.ProgIV.Prode.features.repositories.PrediccionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalcularPuntosService {

    private final PrediccionRepository prediccionRepository;


    public void calcularPuntos(Partido partido) {

        List<Prediccion> predicciones =
                prediccionRepository.findByPartido(partido);


        for(Prediccion prediccion : predicciones) {

            int puntos = 0;


            // Resultado exacto
            if(
                prediccion.getGolLocal().equals(partido.getGolLocal())
                &&
                prediccion.getGolVisitante().equals(partido.getGolVisitante())
            ){
                puntos = 3;
                prediccion.setEsExacta(true);
            }

            // Solo acertó ganador/empate
            else if(
                obtenerResultado(prediccion.getGolLocal(),
                                 prediccion.getGolVisitante())
                .equals(
                obtenerResultado(partido.getGolLocal(),
                                 partido.getGolVisitante()))
            ){
                puntos = 1;
                prediccion.setEsTendencia(true);
            }


            prediccion.setPuntosObtenidos(puntos);

        }


        prediccionRepository.saveAll(predicciones);
    }



    private String obtenerResultado(Integer local, Integer visitante){

        if(local > visitante)
            return "LOCAL";

        if(local < visitante)
            return "VISITANTE";

        return "EMPATE";
    }

}