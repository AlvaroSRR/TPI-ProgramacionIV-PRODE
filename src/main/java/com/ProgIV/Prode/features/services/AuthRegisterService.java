package com.ProgIV.Prode.features.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.usuario.EmailYaRegistradoException;
import com.ProgIV.Prode.features.dtos.request.RegisterRequestDTO;
import com.ProgIV.Prode.features.dtos.response.RegisterResponseDTO;
import com.ProgIV.Prode.features.models.Rol;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthRegisterService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponseDTO register(RegisterRequestDTO dto) {

        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new EmailYaRegistradoException();
        }

        Usuario user = new Usuario();
        user.setNombreUsuario(dto.nombreUsuario());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRol(Rol.USER);
        user.setActivo(true);

        Usuario saved = usuarioRepository.save(user);

        return new RegisterResponseDTO(
                saved.getId(),
                saved.getNombreUsuario(),
                saved.getEmail(),
                saved.getRol().name());
    }
}