package com.ProgIV.Prode.features.services.impl.partido;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.partido.PartidoNoEncontradoException;
import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.repositories.PrediccionRepository;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoDeleteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoDeleteService implements IPartidoDeleteService {

    private final PartidoRepository partidoRepository;
    private final PrediccionRepository prediccionRepository;

    @Override
    public void eliminarPartido(Long id) {

        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new PartidoNoEncontradoException(id));

        if (partido.getEstadoPartido() != EstadoPartido.POR_JUGARSE) {
            throw new RuntimeException(
                    "Solo se pueden eliminar partidos en estado POR_JUGARSE");
        }

        if (prediccionRepository.existsByPartidoId(id)) {
            throw new RuntimeException(
                    "No se puede eliminar un partido con pronósticos registrados");
        }

        partido.setEliminado(true);

        partidoRepository.save(partido);
    }
}