package com.ProgIV.Prode.controllers.Patch;

import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.UsuarioUpdateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.UsuarioResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.usuario.IUsuarioUpdateService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class UsuarioUpdateController {
    private final IUsuarioUpdateService usuarioUpdateService;

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(
            @PathVariable Long id,
            @RequestBody UsuarioUpdateRequestDTO dto,
            Authentication authentication) {
 
        return ResponseEntity.ok(
                usuarioUpdateService.update(id, dto, authentication));
    }
}
