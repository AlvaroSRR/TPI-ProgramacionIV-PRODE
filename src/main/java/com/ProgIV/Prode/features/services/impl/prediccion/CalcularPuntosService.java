package com.ProgIV.Prode.features.services.impl.prediccion;

import java.util.*;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.models.Prediccion;
import com.ProgIV.Prode.features.repositories.PrediccionRepository;
import com.ProgIV.Prode.features.services.interfaces.prediccion.ICalcularPuntosService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalcularPuntosService implements ICalcularPuntosService {

    private final PrediccionRepository prediccionRepository;

    public void calcularPuntos(Partido partido) {

        // IDEMPOTENCIA (CLAVE)
        if (partido.isPuntosCalculados()) {
            return;
        }

        List<Prediccion> predicciones = prediccionRepository.findByPartido(partido);

        for (Prediccion prediccion : predicciones) {

            int puntos = 0;

            //Resultado exacto
            if (prediccion.getGolLocal().equals(partido.getGolLocal())
                    && prediccion.getGolVisitante().equals(partido.getGolVisitante())) {

                puntos = 3;
                prediccion.setEsExacta(true);
            }

            // Resultado tendencia (ganador/empate)
            else if (obtenerResultado(prediccion.getGolLocal(), prediccion.getGolVisitante())
                    .equals(obtenerResultado(partido.getGolLocal(), partido.getGolVisitante()))) {

                puntos = 1;
                prediccion.setEsTendencia(true);
            }

            prediccion.setPuntosObtenidos(puntos);
        }

        prediccionRepository.saveAll(predicciones);

        //MARCA COMO YA CALCULADO
        partido.setPuntosCalculados(true);
    }

    private String obtenerResultado(Integer local, Integer visitante) {

        if (local > visitante)
            return "LOCAL";

        if (local < visitante)
            return "VISITANTE";

        return "EMPATE";
    }
}