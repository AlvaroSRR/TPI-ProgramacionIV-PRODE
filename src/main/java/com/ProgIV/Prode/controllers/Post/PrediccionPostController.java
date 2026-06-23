package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ProgIV.Prode.features.dtos.request.PrediccionCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.PrediccionResponseDTO;
import com.ProgIV.Prode.features.mappers.PrediccionMapper;
import com.ProgIV.Prode.features.models.Prediccion;
import com.ProgIV.Prode.features.services.impl.prediccion.PrediccionCreateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/predicciones")
@RequiredArgsConstructor
public class PrediccionPostController {

        private final PrediccionCreateService service;
        private final PrediccionMapper mapper;

        @PostMapping
        public ResponseEntity<PrediccionResponseDTO> crear(@RequestBody PrediccionCreateRequestDTO dto) {

                Prediccion prediccion = service.guardarPrediccion(dto);

                return ResponseEntity.ok(mapper.toDTO(prediccion));
        }
}
