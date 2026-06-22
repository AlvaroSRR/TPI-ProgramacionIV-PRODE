package com.ProgIV.Prode.features.services.impl.partido;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.request.PartidoUpdateRequestDTO;
import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoUpdateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoUpdateService implements IPartidoUpdateService{
    
    private final PartidoRepository partidoRepository;

    @Override
    public Partido actualizarResultado(PartidoUpdateRequestDTO dto) {

        Partido partido = partidoRepository.findById(dto.partidoId())
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

        if (partido.getEstadoPartido() == EstadoPartido.FINALIZADO) {
            throw new RuntimeException(
                    "Solo se pueden registrar resultados en partidos no finalizados");
        }

        // Control para que no permita cargar resultados si el partido no comenzo
        // if (partido.getEstadoPartido() != EstadoPartido.EN_JUEGO) {
        //     throw new RuntimeException(
        //             "El partido debe estar EN_JUEGO para registrar el resultado");
        // }

        partido.setGolLocal(dto.golLocal());
        partido.setGolVisitante(dto.golVisitante());
        partido.setEstadoPartido(EstadoPartido.FINALIZADO);

        if (dto.golLocal() > dto.golVisitante()) {
            partido.setResultado("LOCAL");
        } else if (dto.golLocal() < dto.golVisitante()) {
            partido.setResultado("VISITANTE");
        } else {
            partido.setResultado("EMPATE");
        }

        return partidoRepository.save(partido);
}
}
