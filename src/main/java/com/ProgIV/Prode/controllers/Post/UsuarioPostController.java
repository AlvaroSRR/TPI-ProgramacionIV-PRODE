package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.UsuarioCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.usuario.IUsuarioCreateService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN')")
public class UsuarioPostController {
    private final IUsuarioCreateService usuarioCreateService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(
            @Valid @RequestBody UsuarioCreateRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioCreateService.create(dto));
    }
}
