package com.ProgIV.Prode.controllers.Delete;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.services.interfaces.equipo.IEquipoDeleteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/equipos")
@PreAuthorize("hasAnyRole('ADMIN')")
@AllArgsConstructor
public class EquipoDeleteController {
    private final IEquipoDeleteService equipoDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        equipoDeleteService.delete(id);
        return ResponseEntity.ok("Equipo eliminado correctamente");
    }
}
