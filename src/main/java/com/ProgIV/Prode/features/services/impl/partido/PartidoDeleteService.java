package com.ProgIV.Prode.features.services.impl.partido;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoDeleteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoDeleteService implements IPartidoDeleteService {

    private final PartidoRepository partidoRepository;

    @Override
    public void eliminarPartido(Long id) {

        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

    }
}