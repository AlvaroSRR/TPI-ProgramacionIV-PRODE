package com.ProgIV.Prode.features.services.impl.partido;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.BusinessException;

import com.ProgIV.Prode.exceptions.equipo.EquipoNoEncontradoException;
import com.ProgIV.Prode.exceptions.fecha.FechaNoEncontradaException;
import com.ProgIV.Prode.features.dtos.request.PartidoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.PartidoResponseDTO;
import com.ProgIV.Prode.features.mappers.PartidoMapper;
import com.ProgIV.Prode.features.models.Equipo;
import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.repositories.EquipoRepository;
import com.ProgIV.Prode.features.repositories.FechaRepository;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoCreateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoCreateService implements IPartidoCreateService {

    private final PartidoRepository partidoRepository;
    private final FechaRepository fechaRepository;
    private final EquipoRepository equipoRepository;
    private final PartidoMapper partidoMapper;

    @Override
    public PartidoResponseDTO crearPartido(PartidoCreateRequestDTO dto) {

        if (dto.getEquipoLocalId().equals(dto.getEquipoVisitanteId())) {
            throw new RuntimeException("El equipo local y visitante no pueden ser el mismo");
        }

        Fecha fecha = fechaRepository.findById(dto.getFechaId())
                .orElseThrow(() -> new RuntimeException("Fecha no encontrada"));

        Equipo local = equipoRepository.findById(dto.getEquipoLocalId())
                .orElseThrow(() -> new RuntimeException("Equipo local no encontrado"));

        Equipo visitante = equipoRepository.findById(dto.getEquipoVisitanteId())
                .orElseThrow(() -> new RuntimeException("Equipo visitante no encontrado"));

        Partido partido = new Partido();
        partido.setFecha(fecha);
        partido.setEquipoLocal(local);
        partido.setEquipoVisitante(visitante);
        partido.setHoraInicio(dto.getHoraInicio());
        partido.setEstadoPartido(EstadoPartido.POR_JUGARSE);
        partido.setGolLocal(null);
        partido.setGolVisitante(null);
        partido.setResultado(null);
        partido.setResultadoCargado(false);
        partido.setPuntosCalculados(false);
        partido.setEliminado(false);

        Partido saved = partidoRepository.save(partido);

        return partidoMapper.toDTO(saved);
    }
}