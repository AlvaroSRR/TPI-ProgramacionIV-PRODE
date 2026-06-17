package com.ProgIV.Prode.features.services.impl.equipo;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.equipo.EquipoDuplicadoException;
import com.ProgIV.Prode.features.dtos.request.EquipoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;
import com.ProgIV.Prode.features.mappers.EquipoMapper;
import com.ProgIV.Prode.features.models.Equipo;
import com.ProgIV.Prode.features.repositories.EquipoRepository;
import com.ProgIV.Prode.features.services.interfaces.equipo.IEquipoCreateService;

@Service
public class EquipoCreateService implements IEquipoCreateService {

    private final EquipoRepository equipoRepository;
    private final EquipoMapper equipoMapper;

    public EquipoCreateService(
            EquipoRepository equipoRepository,
            EquipoMapper equipoMapper) {

        this.equipoRepository = equipoRepository;
        this.equipoMapper = equipoMapper;
    }

    @Override
    public EquipoResponseDTO crearEquipo(EquipoCreateRequestDTO request) {

        if (equipoRepository.existsByNombre(request.getNombre())) {
            throw new EquipoDuplicadoException(request.getNombre());
        }

        Equipo equipo = equipoMapper.toEntity(request);

        equipo = equipoRepository.save(equipo);

        return equipoMapper.toResponse(equipo);
    }
}