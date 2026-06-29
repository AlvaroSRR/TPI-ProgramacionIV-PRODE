package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.UsuarioCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;
import com.ProgIV.Prode.features.services.impl.usuario.UsuarioCreateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class RegisterPostController {
    private final UsuarioCreateService usuarioCreateService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDTO> register(
            @RequestBody UsuarioCreateRequestDTO dto) {
        return ResponseEntity.ok(
                usuarioCreateService.create(dto));
    }
}
