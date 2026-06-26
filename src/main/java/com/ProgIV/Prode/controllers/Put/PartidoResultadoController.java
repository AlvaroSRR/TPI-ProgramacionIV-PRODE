package com.ProgIV.Prode.controllers.Put;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.ResultadoPartidoRequestDTO;
import com.ProgIV.Prode.features.services.impl.partido.PartidoResultadoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/partidos")
@RequiredArgsConstructor
public class PartidoResultadoController {
    private final PartidoResultadoService partidoResultadoService;

    @PutMapping("/resultado")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> cargarResultado(
            @RequestBody ResultadoPartidoRequestDTO dto) {

        partidoResultadoService.cargarResultado(dto);

        return ResponseEntity.ok("Resultado cargado correctamente");
    }
}
