package com.ProgIV.Prode.controllers.Get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.models.Prediccion;
import com.ProgIV.Prode.features.services.interfaces.prediccion.IPrediccionGetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/predicciones")
@RequiredArgsConstructor
public class PrediccionGetController {


    private final IPrediccionGetService prediccionGetService;


    @GetMapping
    public ResponseEntity<List<Prediccion>> obtenerPredicciones() {

        return ResponseEntity.ok(
                prediccionGetService.obtenerPredicciones()
        );
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Prediccion>> obtenerPorUsuario(
            @PathVariable Long id
    ){

        return ResponseEntity.ok(
                prediccionGetService.obtenerPrediccionesUsuario(id)
        );

    }


    @GetMapping("/partido/{id}")
    public ResponseEntity<List<Prediccion>> obtenerPorPartido(
            @PathVariable Long id
    ){

        return ResponseEntity.ok(
                prediccionGetService.obtenerPrediccionesPartido(id)
        );

    }
}