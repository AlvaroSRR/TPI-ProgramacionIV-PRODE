package com.ProgIV.Prode.controllers.Get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ProgIV.Prode.features.models.EstadoFecha;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaGetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fechas")
public class FechaGetController {

    private final IFechaGetService fechaService;

    @GetMapping
    public ResponseEntity<List<Fecha>> listarFechas() {
        return ResponseEntity.ok(fechaService.listarFechas());
    }

   @GetMapping("/estado")
    public ResponseEntity<List<Fecha>> listarFechasPorEstado(
        @RequestParam EstadoFecha estado) {

    return ResponseEntity.ok(fechaService.listarFechasPorEstado(estado));
}
}