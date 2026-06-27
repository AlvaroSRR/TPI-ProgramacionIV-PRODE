package com.ProgIV.Prode.controllers.Get;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.exceptions.usuario.UsuarioNoEncontradoException;
import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {
    private final UsuarioRepository usuarioRepository;

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponseDTO> me(Authentication authentication) {

        //esto viene del JWT
        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNoEncontradoException(email));

        UsuarioResponseDTO dto = UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .email(usuario.getEmail())
                .rol(usuario.getRol().name())
                .build();

        return ResponseEntity.ok(dto);
    }
}
