package com.ProgIV.Prode.features.services.impl.equipo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;
import com.ProgIV.Prode.features.mappers.EquipoMapper;
import com.ProgIV.Prode.features.models.Equipo;
import com.ProgIV.Prode.features.repositories.EquipoRepository;
import com.ProgIV.Prode.features.services.interfaces.equipo.IEquipoGetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EquipoGetService implements IEquipoGetService {

    private final EquipoRepository equipoRepository;
    private final EquipoMapper equipoMapper;

    @Override
    public List<EquipoResponseDTO> getAll() {

        return equipoRepository.findByEliminadoFalse()
                .stream()
                .map(equipoMapper::toResponse)
                .toList();
    }

    @Override
    public EquipoResponseDTO getById(Long id) {

        Equipo equipo = equipoRepository
                .findByIdAndEliminadoFalse(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        return equipoMapper.toResponse(equipo);
    }
}
