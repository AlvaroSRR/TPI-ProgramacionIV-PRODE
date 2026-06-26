package com.ProgIV.Prode.features.services.impl.grupo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;
import com.ProgIV.Prode.features.mappers.GrupoMapper;
import com.ProgIV.Prode.features.models.Grupo;
import com.ProgIV.Prode.features.repositories.GrupoRepository;
import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoGetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GrupoGetService implements IGrupoGetService {

    private final GrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    @Override
    public List<GrupoResponseDTO> getAll() {

        return grupoRepository.findByActivoTrue()
                .stream()
                .map(grupoMapper::toResponseDTO)
                .toList();
    }

    @Override
    public GrupoResponseDTO getById(Long id) {
        Grupo grupo = grupoRepository.findByIdAndActivoTrueWithUsuarios(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        return grupoMapper.toResponseDTO(grupo);
    }
}
