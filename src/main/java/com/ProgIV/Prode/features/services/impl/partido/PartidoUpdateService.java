package com.ProgIV.Prode.features.services.impl.partido;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.BusinessException;
import com.ProgIV.Prode.exceptions.equipo.EquipoNoEncontradoException;
import com.ProgIV.Prode.exceptions.fecha.FechaNoEncontradaException;
import com.ProgIV.Prode.exceptions.partido.PartidoNoEncontradoException;
import com.ProgIV.Prode.exceptions.partido.PartidoNoModificableException;
import com.ProgIV.Prode.features.dtos.request.PartidoUpdateDatosRequestDTO;
import com.ProgIV.Prode.features.models.Equipo;
import com.ProgIV.Prode.features.models.EstadoFecha;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.repositories.EquipoRepository;
import com.ProgIV.Prode.features.repositories.FechaRepository;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoUpdateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoUpdateService implements IPartidoUpdateService {

        private final PartidoRepository partidoRepository;
        // private final ICalcularPuntosService calcularPuntosService;
        // private final IFechaEstadoUpdateService fechaEstadoUpdateService;
        private final EquipoRepository equipoRepository;
        private final FechaRepository fechaRepository;

        // @Override
        // public Partido actualizarResultado(PartidoUpdateRequestDTO dto) {

        // Partido partido = partidoRepository.findById(dto.partidoId())
        // .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

        // if (partido.getEstadoPartido() == EstadoPartido.FINALIZADO) {
        // throw new RuntimeException(
        // "Solo se pueden registrar resultados en partidos no finalizados");
        // }

        // // Control para que no permita cargar resultados si el partido no comenzo

        // if (partido.getEstadoPartido() != EstadoPartido.EN_JUEGO) {
        // throw new RuntimeException(
        // "El partido debe estar EN_JUEGO para registrar el resultado");
        // }

        // partido.setGolLocal(dto.golLocal());
        // partido.setGolVisitante(dto.golVisitante());
        // partido.setEstadoPartido(EstadoPartido.FINALIZADO);

        // if (dto.golLocal() > dto.golVisitante()) {
        // partido.setResultado("LOCAL");
        // } else if (dto.golLocal() < dto.golVisitante()) {
        // partido.setResultado("VISITANTE");
        // } else {
        // partido.setResultado("EMPATE");
        // }

        // fechaEstadoUpdateService.finalizarEstadoFecha(partido.getFecha().getId());
        // calcularPuntosService.calcularPuntos(partido);
        // return partidoRepository.save(partido);
        // }

        @Override
        public Partido actualizar(Long id, PartidoUpdateDatosRequestDTO dto) {

                Partido partido = partidoRepository.findById(id)
                                .orElseThrow(() -> new PartidoNoEncontradoException(id));

                OffsetDateTime ahora = OffsetDateTime.now();

                if (!ahora.isBefore(partido.getHoraInicio().minusMinutes(30))) {
                        throw new PartidoNoModificableException();
                }

                Fecha fecha = fechaRepository.findById(dto.getFechaId())
                                .orElseThrow(() -> new FechaNoEncontradaException(dto.getFechaId()));
                if (fecha.getEstado() != EstadoFecha.PROGRAMADA) {
                        throw new BusinessException(
                                        "Solo se pueden asignar partidos a fechas en estado PROGRAMADA");
                }
                
                Equipo local = equipoRepository.findById(dto.getEquipoLocalId())
                                .orElseThrow(() -> new EquipoNoEncontradoException(dto.getEquipoLocalId()));

                Equipo visitante = equipoRepository.findById(dto.getEquipoVisitanteId())
                                .orElseThrow(() -> new EquipoNoEncontradoException(dto.getEquipoVisitanteId()));

                partido.setEquipoLocal(local);
                partido.setEquipoVisitante(visitante);
                partido.setFecha(fecha);
                partido.setHoraInicio(dto.getHoraInicio());

                return partidoRepository.save(partido);
        }
}
