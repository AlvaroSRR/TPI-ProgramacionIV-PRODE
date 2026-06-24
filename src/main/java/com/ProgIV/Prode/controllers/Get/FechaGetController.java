package com.ProgIV.Prode.controllers.Get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaGetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fechas")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class FechaGetController {

    private final IFechaGetService fechaService;

    @GetMapping
    public ResponseEntity<List<Fecha>> listarFechas() {
        return ResponseEntity.ok(fechaService.listarFechas());
    }
}