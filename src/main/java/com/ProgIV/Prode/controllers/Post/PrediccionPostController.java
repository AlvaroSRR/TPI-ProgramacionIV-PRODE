package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ProgIV.Prode.features.dtos.request.PrediccionCreateRequestDTO;
import com.ProgIV.Prode.features.models.Prediccion;
import com.ProgIV.Prode.features.services.interfaces.prediccion.IPrediccionCreateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/predicciones")
@RequiredArgsConstructor
public class PrediccionPostController {

    private final IPrediccionCreateService prediccionCreateService;


    @PostMapping
    public ResponseEntity<Prediccion> guardarPrediccion(
            @RequestBody PrediccionCreateRequestDTO dto
    ) {

        Prediccion prediccion =
                prediccionCreateService.guardarPrediccion(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(prediccion);
    }
}