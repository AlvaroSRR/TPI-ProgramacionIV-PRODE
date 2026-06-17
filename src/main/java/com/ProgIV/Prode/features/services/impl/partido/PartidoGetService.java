package com.ProgIV.Prode.features.services.impl.partido;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoGetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoGetService implements IPartidoGetService {

    private final PartidoRepository partidoRepository;

    @Override
    public List<Partido> listarPartidos(Long fechaId) {

        if (fechaId != null) {
            return partidoRepository.findByFechaIdOrderByHoraInicioAsc(fechaId);
        }

        return partidoRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Partido::getHoraInicio))
                .toList();
    }
}