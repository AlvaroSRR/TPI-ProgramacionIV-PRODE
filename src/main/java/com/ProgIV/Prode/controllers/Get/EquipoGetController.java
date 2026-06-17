package com.ProgIV.Prode.controllers.Get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.equipo.IEquipoGetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/equipos")
@RequiredArgsConstructor
public class EquipoGetController {

    private final IEquipoGetService equipoGetService;

    @GetMapping
    public ResponseEntity<List<EquipoResponseDTO>> getAll() {
        return ResponseEntity.ok(equipoGetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(equipoGetService.getById(id));
    }
}