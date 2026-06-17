package com.ProgIV.Prode.controllers.Delete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.services.interfaces.equipo.IEquipoDeleteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/equipos")
@AllArgsConstructor
public class EquipoDeleteController {
    private final IEquipoDeleteService equipoDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipoDeleteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
