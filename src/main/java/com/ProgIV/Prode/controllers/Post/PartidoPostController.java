package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.PartidoCreateRequestDTO;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoCreateService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/partidos")
public class PartidoPostController {
    
    private final IPartidoCreateService partidoCreateService;

    @PostMapping
    public ResponseEntity<Partido> crear(@RequestBody PartidoCreateRequestDTO dto) {
        return ResponseEntity.ok(partidoCreateService.crearPartido(dto));
    }
}
