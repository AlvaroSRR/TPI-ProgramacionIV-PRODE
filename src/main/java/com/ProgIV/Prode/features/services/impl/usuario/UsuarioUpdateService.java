package com.ProgIV.Prode.features.services.impl.usuario;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.request.UsuarioUpdateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;
import com.ProgIV.Prode.features.mappers.UsuarioMapper;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;
import com.ProgIV.Prode.features.services.interfaces.usuario.IUsuarioUpdateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioUpdateService implements IUsuarioUpdateService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioFindByIdService usuarioFindByIdService;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDTO update(
            Long id,
            UsuarioUpdateRequestDTO dto) {

        Usuario usuario = usuarioFindByIdService.execute(id);

        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setEmail(dto.getEmail());

        Usuario actualizado = usuarioRepository.save(usuario);

        return usuarioMapper.toResponseDTO(actualizado);
    }
    
}
