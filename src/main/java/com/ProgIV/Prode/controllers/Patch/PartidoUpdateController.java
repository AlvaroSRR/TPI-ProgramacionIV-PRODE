package com.ProgIV.Prode.controllers.Patch;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ProgIV.Prode.features.dtos.request.PartidoUpdateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.ApiResponse;
import com.ProgIV.Prode.features.dtos.response.PartidoResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoUpdateService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/partidos")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN')")
public class PartidoUpdateController {

    private final IPartidoUpdateService partidoUpdateService;

    @PutMapping
    public ResponseEntity<ApiResponse<PartidoResponseDTO>> update(
            @Valid @RequestBody PartidoUpdateRequestDTO dto) {

        PartidoResponseDTO response = partidoUpdateService.actualizarResultado(dto);

        return ResponseEntity.ok(
                new ApiResponse<>("Resultado actualizado correctamente", response)
        );
    }
}