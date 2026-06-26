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

        List<Grupo> grupos = grupoRepository.findByActivoTrue();

        for (Grupo grupo : grupos) {
            System.out.println(
                    "Grupo " + grupo.getId() +
                            " -> usuarios: " + grupo.getUsuarios().size());
        }

        return grupos.stream()
                .map(grupoMapper::toResponseDTO)
                .toList();
    }

    @Override
    public GrupoResponseDTO getById(Long id) {

        Grupo grupo = grupoRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        return grupoMapper.toResponseDTO(grupo);
    }
}
