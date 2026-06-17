package com.ProgIV.Prode.features.services.impl.equipo;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.request.EquipoUpdateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;
import com.ProgIV.Prode.features.mappers.EquipoMapper;
import com.ProgIV.Prode.features.models.Equipo;
import com.ProgIV.Prode.features.repositories.EquipoRepository;
import com.ProgIV.Prode.features.services.interfaces.equipo.IEquipoUpdateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipoUpdateService implements IEquipoUpdateService {

    private final EquipoRepository equipoRepository;
    private final EquipoMapper equipoMapper;

    @Override
    public EquipoResponseDTO update(Long id, EquipoUpdateRequestDTO dto) {

        Equipo equipo = equipoRepository.findByIdAndEliminadoFalse(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        equipo.setNombre(dto.nombre());

        Equipo saved = equipoRepository.save(equipo);

        return equipoMapper.toResponse(saved);
    }
}