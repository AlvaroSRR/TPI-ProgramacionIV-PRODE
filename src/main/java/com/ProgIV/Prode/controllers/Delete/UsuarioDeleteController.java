package com.ProgIV.Prode.controllers.Delete;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.services.interfaces.usuario.IUsuarioDeleteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@PreAuthorize("hasAnyRole('ADMIN')")
@AllArgsConstructor
public class UsuarioDeleteController {
    private final IUsuarioDeleteService usuarioDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        usuarioDeleteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
