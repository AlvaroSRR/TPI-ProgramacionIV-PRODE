package com.ProgIV.Prode.features.services.impl.usuario;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.usuario.EmailYaRegistradoException;
import com.ProgIV.Prode.exceptions.usuario.UsuarioYaExisteException;
import com.ProgIV.Prode.features.dtos.request.UsuarioCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;
import com.ProgIV.Prode.features.mappers.UsuarioMapper;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;
import com.ProgIV.Prode.features.services.interfaces.usuario.IUsuarioCreateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioCreateService implements IUsuarioCreateService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponseDTO create(UsuarioCreateRequestDTO dto) {
        if (usuarioRepository.existsByNombreUsuario(dto.getNombreUsuario())) {
            throw new UsuarioYaExisteException(dto.getNombreUsuario());
        }

        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new EmailYaRegistradoException(dto.getEmail());
        }

        Usuario usuario = usuarioMapper.toEntity(dto, passwordEncoder.encode(dto.getPassword()));

        Usuario guardado = usuarioRepository.save(usuario);
        
        return usuarioMapper.toResponseDTO(guardado);

    }

}
