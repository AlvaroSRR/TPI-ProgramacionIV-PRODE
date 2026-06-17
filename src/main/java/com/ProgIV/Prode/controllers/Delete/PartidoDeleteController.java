package com.ProgIV.Prode.controllers.Delete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoDeleteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/partidos")
public class PartidoDeleteController {

    private final IPartidoDeleteService partidoDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        partidoDeleteService.eliminarPartido(id);

        return ResponseEntity.noContent().build();
    }
}
