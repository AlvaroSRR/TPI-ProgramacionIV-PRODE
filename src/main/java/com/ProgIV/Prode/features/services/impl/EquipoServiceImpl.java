package com.ProgIV.Prode.features.services.impl;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.request.CreateEquipoRequest;
import com.ProgIV.Prode.features.dtos.response.EquipoResponse;
import com.ProgIV.Prode.features.models.Equipo;
import com.ProgIV.Prode.features.repositories.EquipoRepository;
import com.ProgIV.Prode.features.services.interfaces.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public EquipoResponse crearEquipo(CreateEquipoRequest request) {

        if (equipoRepository.existsByNombre(request.getNombre())) {
            throw new IllegalArgumentException(
                "El equipo con nombre " + request.getNombre() + " ya existe"
            );
        }

        Equipo equipo = new Equipo();
        equipo.setNombre(request.getNombre());

        equipo = equipoRepository.save(equipo);

        return new EquipoResponse(
                equipo.getId(),
                equipo.getNombre()
        );
    }
}