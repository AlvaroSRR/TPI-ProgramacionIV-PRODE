package com.ProgIV.Prode.features.services.impl.grupo;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.request.GrupoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;
import com.ProgIV.Prode.features.mappers.GrupoMapper;
import com.ProgIV.Prode.features.models.Grupo;
import com.ProgIV.Prode.features.repositories.GrupoRepository;
import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoUpdateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GrupoUpdateService implements IGrupoUpdateService {

    private final GrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    @Override
    public GrupoResponseDTO update(Long id, GrupoCreateRequestDTO dto) {

        Grupo grupo = grupoRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        grupo.setNombre(dto.getNombre());

        Grupo actualizado = grupoRepository.save(grupo);

        return grupoMapper.toResponseDTO(actualizado);
    }
}
