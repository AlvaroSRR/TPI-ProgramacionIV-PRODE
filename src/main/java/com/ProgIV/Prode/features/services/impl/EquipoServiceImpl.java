package com.ProgIV.Prode.features.services.impl;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.equipo.EquipoDuplicadoException;
import com.ProgIV.Prode.features.dtos.request.EquipoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;
import com.ProgIV.Prode.features.mappers.EquipoMapper;
import com.ProgIV.Prode.features.models.Equipo;
import com.ProgIV.Prode.features.repositories.EquipoRepository;
import com.ProgIV.Prode.features.services.interfaces.IEquipoService;

@Service
public class EquipoServiceImpl implements IEquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public EquipoResponseDTO crearEquipo(EquipoCreateRequestDTO request) {

        if (equipoRepository.existsByNombre(request.getNombre())) {
            throw new EquipoDuplicadoException(request.getNombre());
        }
        Equipo equipo = EquipoMapper.toEntity(request);
        equipo = equipoRepository.save(equipo);
        return EquipoMapper.toResponse(equipo);
    }
}