package com.ProgIV.Prode.features.services.impl.usuario;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
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
            UsuarioUpdateRequestDTO dto,
            Authentication authentication) {

        Usuario usuario = usuarioFindByIdService.execute(id);

        boolean esAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        boolean esElMismoUsuario = usuario.getEmail().equals(authentication.getName());

        if (!esAdmin && !esElMismoUsuario) {
            throw new AccessDeniedException("No podés modificar el perfil de otro usuario");
        }

        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setEmail(dto.getEmail());

        Usuario actualizado = usuarioRepository.save(usuario);

        return usuarioMapper.toResponseDTO(actualizado);
    }
}