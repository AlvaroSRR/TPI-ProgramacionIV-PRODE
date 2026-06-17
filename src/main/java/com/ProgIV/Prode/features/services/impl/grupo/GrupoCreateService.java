package com.ProgIV.Prode.features.services.impl.grupo;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.grupo.GrupoYaExisteException;
import com.ProgIV.Prode.features.dtos.request.GrupoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;
import com.ProgIV.Prode.features.mappers.GrupoMapper;
import com.ProgIV.Prode.features.models.Grupo;
import com.ProgIV.Prode.features.repositories.GrupoRepository;
import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoCreateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GrupoCreateService implements IGrupoCreateService {

        private final GrupoRepository grupoRepository;
        private final GrupoMapper grupoMapper;

        @Override
        public GrupoResponseDTO create(GrupoCreateRequestDTO dto) {

                if (grupoRepository.existsByNombre(dto.getNombre())) {
                        throw new GrupoYaExisteException(dto.getNombre());
                }

                String codigo = UUID.randomUUID()
                                .toString()
                                .substring(0, 6)
                                .toUpperCase();

                Grupo grupo = grupoMapper.toEntity(dto, codigo);

                Grupo guardado = grupoRepository.save(grupo);

                return grupoMapper.toResponseDTO(guardado);

        }
}