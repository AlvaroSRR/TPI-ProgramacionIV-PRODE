package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.EquipoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.EquipoResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.equipo.IEquipoCreateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/equipos")
public class EquipoPostController {
    
    private final IEquipoCreateService equipoService;

    public EquipoPostController(IEquipoCreateService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping
    public ResponseEntity<EquipoResponseDTO> crearEquipo(
            @Valid @RequestBody EquipoCreateRequestDTO request) {

        return ResponseEntity.status(HttpStatus.CREATED)
        .body(equipoService.crearEquipo(request));
    }
}
