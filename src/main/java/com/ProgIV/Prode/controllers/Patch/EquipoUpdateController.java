package com.ProgIV.Prode.controllers.Patch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.EquipoUpdateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.equipo.IEquipoUpdateService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/equipos")
@AllArgsConstructor
@RestController
public class EquipoUpdateController {

    private final IEquipoUpdateService equipoUpdateService;

    @PutMapping("/{id}")
    public ResponseEntity<EquipoResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody EquipoUpdateRequestDTO dto) {

        return ResponseEntity.ok(equipoUpdateService.update(id, dto));
    }
}
