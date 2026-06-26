package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ProgIV.Prode.features.dtos.request.GrupoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoCreateService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/grupos")
@AllArgsConstructor
@Validated
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class GrupoPostController {

    private final IGrupoCreateService grupoCreateService;

    @PostMapping
    public ResponseEntity<GrupoResponseDTO> create(
            @Valid @RequestBody GrupoCreateRequestDTO dto) {

        GrupoResponseDTO response = grupoCreateService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}