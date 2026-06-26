package com.ProgIV.Prode.controllers.Patch;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.FechaUpdateDTO;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaUpdateService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fechas")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN')")
public class FechaUpdateController {

    private final IFechaUpdateService fechaUpdateService;


    @PutMapping("/{id}")
    public ResponseEntity<Fecha> update(
            @PathVariable Long id,
            @Valid @RequestBody FechaUpdateDTO dto) {

        Fecha fecha = fechaUpdateService.update(
                id,
                dto.getNombre()
        );

        return ResponseEntity.ok(fecha);
    }
}