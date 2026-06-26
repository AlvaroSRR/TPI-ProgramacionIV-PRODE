package com.ProgIV.Prode.features.services.impl.partido;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.partido.PartidoNoEncontradoException;
import com.ProgIV.Prode.exceptions.partido.ResultadoYaCargadoException;
import com.ProgIV.Prode.features.dtos.request.ResultadoPartidoRequestDTO;
import com.ProgIV.Prode.features.models.EstadoFecha;
import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.impl.prediccion.CalcularPuntosService;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaEstadoUpdateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoResultadoService {

    private final PartidoRepository partidoRepository;
    private final CalcularPuntosService calcularPuntosService;
    private final IFechaEstadoUpdateService estadoFecha;

    public void cargarResultado(ResultadoPartidoRequestDTO dto) {

        Partido partido = partidoRepository.findById(dto.getPartidoId())
                .orElseThrow(() -> new PartidoNoEncontradoException(dto.getPartidoId()));

        //BLOQUEO FUERTE
        if (partido.isResultadoCargado()
                || partido.getEstadoPartido() == EstadoPartido.FINALIZADO) {
            throw new ResultadoYaCargadoException();
        }

        //VALIDACIÓN DE FECHA
        if (partido.getFecha().getEstado() != EstadoFecha.EN_JUEGO) {
            throw new IllegalStateException("La fecha no está en juego");
        }

        //CARGA DE RESULTADO
        partido.setGolLocal(dto.getGolLocal());
        partido.setGolVisitante(dto.getGolVisitante());
        partido.setEstadoPartido(EstadoPartido.FINALIZADO);
        partido.setResultadoCargado(true);

        //CALCULO PUNTOS
        calcularPuntosService.calcularPuntos(partido);

        //FINALIZAR FECHA
              // estadoFecha.finalizarEstadoFecha(partido.getFecha().getId());

        partidoRepository.save(partido);

    }
}
