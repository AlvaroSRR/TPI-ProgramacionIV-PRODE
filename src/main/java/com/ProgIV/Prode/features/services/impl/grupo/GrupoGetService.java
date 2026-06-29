package com.ProgIV.Prode.features.services.impl.grupo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;
import com.ProgIV.Prode.features.mappers.GrupoMapper;
import com.ProgIV.Prode.features.models.Grupo;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.GrupoRepository;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;
import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoGetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GrupoGetService implements IGrupoGetService {
    private final GrupoRepository grupoRepository;
    private final UsuarioRepository usuarioRepository;
    private final GrupoMapper grupoMapper;

    @Override
    public List<GrupoResponseDTO> getAll(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuario.getGrupos().stream().filter(Grupo::getActivo).map(grupoMapper::toResponseDTO).toList();
    }

    @Override
    public GrupoResponseDTO getById(Long id) {
        Grupo grupo = grupoRepository.findByIdAndActivoTrueWithUsuarios(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
        return grupoMapper.toResponseDTO(grupo);
    }

    @Override
    public List<GrupoResponseDTO> getAll() {
        return grupoRepository.findAll().stream().map(grupoMapper::toResponseDTO).toList();
    }
}
