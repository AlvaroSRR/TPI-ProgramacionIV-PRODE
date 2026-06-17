package com.ProgIV.Prode.controllers.Get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.services.impl.partido.PartidoGetService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/partidos")

public class PartidoGetController {
    
    private final PartidoGetService partidoGetService;

    @GetMapping
public ResponseEntity<List<Partido>> listar(
        @RequestParam(required = false) Long fechaId) {

    return ResponseEntity.ok(partidoGetService.listarPartidos(fechaId));
}
}
