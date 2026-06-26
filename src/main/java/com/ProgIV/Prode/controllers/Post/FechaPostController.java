package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.FechaCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.ApiResponse;
import com.ProgIV.Prode.features.dtos.response.FechaResponseDTO;
import com.ProgIV.Prode.features.services.impl.fecha.FechaCreateService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fechas")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN')")

public class FechaPostController {

    private final FechaCreateService fechaService;

    @PostMapping
    public ResponseEntity<ApiResponse<FechaResponseDTO>> crearFecha(
            @Valid @RequestBody FechaCreateRequestDTO dto) {

        FechaResponseDTO response = fechaService.crearFecha(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Fecha creada correctamente", response));
    }
}