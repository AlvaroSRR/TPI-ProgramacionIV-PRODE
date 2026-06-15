package com.ProgIV.Prode.features.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.CredencialesInvalidasException;
import com.ProgIV.Prode.features.dtos.request.LoginRequestDTO;
import com.ProgIV.Prode.features.dtos.response.LoginResponseDTO;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;
import com.ProgIV.Prode.features.services.interfaces.IAuthLoginService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthLoginService implements IAuthLoginService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {

        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new CredencialesInvalidasException());

        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new CredencialesInvalidasException();
        }

        String token = jwtService.generateToken(usuario);

        return LoginResponseDTO.builder()
                .token(token)
                .build();
    }
}
