package com.ProgIV.Prode.controllers.Delete;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaDeleteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/fechas")
@PreAuthorize("hasAnyRole('ADMIN')")
@AllArgsConstructor
public class FechaDeleteController {
        
    private final IFechaDeleteService fechaDeleteService;

    @DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarFecha(@PathVariable Long id) {

    fechaDeleteService.eliminarFecha(id);

    return ResponseEntity.noContent().build();
    }
}
