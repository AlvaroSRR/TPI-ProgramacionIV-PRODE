package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.FechaCreateRequestDTO;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.services.impl.fecha.FechaCreateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fechas")
@RequiredArgsConstructor

public class FechaPostController {

    private final FechaCreateService fechaService;

    @PostMapping
    public ResponseEntity<Fecha> crearFecha(@RequestBody FechaCreateRequestDTO dto) {
        return ResponseEntity.ok(fechaService.crearFecha(dto));
    }
}