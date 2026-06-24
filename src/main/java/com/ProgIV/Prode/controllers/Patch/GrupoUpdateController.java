package com.ProgIV.Prode.controllers.Patch;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.GrupoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoUpdateService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/grupos")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class GrupoUpdateController {

private final IGrupoUpdateService grupoUpdateService;

@PutMapping("/{id}")
public ResponseEntity<GrupoResponseDTO> update(
        @PathVariable Long id,
        @Valid @RequestBody GrupoCreateRequestDTO dto) {

    return ResponseEntity.ok(
            grupoUpdateService.update(id, dto));
}

}