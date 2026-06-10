package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.CreateEquipoRequest;
import com.ProgIV.Prode.features.dtos.response.EquipoResponse;
import com.ProgIV.Prode.features.services.interfaces.EquipoService;

@RestController
@RequestMapping("/equipos")
public class CreateEquipoController {
    
    private final EquipoService equipoService;

    public CreateEquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping
    public ResponseEntity<EquipoResponse> crearEquipo(
        @RequestBody CreateEquipoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
        .body(equipoService.crearEquipo(request));
    }
}
