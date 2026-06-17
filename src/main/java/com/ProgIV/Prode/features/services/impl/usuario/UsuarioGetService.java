package com.ProgIV.Prode.features.services.impl.usuario;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;
import com.ProgIV.Prode.features.mappers.UsuarioMapper;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioGetService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioFindByIdService usuarioFindByIdService;

    public List<UsuarioResponseDTO> getAll() {

        return usuarioRepository.findByActivoTrue()
                .stream()
                .map(usuarioMapper::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO getById(Long id) {

        Usuario usuario = usuarioFindByIdService.execute(id);

        return usuarioMapper.toResponseDTO(usuario);
    }
}
