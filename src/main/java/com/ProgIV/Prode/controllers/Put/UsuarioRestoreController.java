package com.ProgIV.Prode.controllers.Put;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.services.interfaces.usuario.IUsuarioRestoreService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN')")
public class UsuarioRestoreController {
 
    private final IUsuarioRestoreService usuarioRestoreService;
 
    @PutMapping("/{id}/restore")
    public ResponseEntity<Void> restore(@PathVariable Long id) {
 
        usuarioRestoreService.restore(id);
 
        return ResponseEntity.noContent().build();
    }
}