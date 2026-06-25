package com.ProgIV.Prode.controllers.Get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.response.PrediccionResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.prediccion.IPrediccionGetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/predicciones")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")

public class PrediccionGetController {

        private final IPrediccionGetService prediccionGetService;

        @GetMapping
        public ResponseEntity<List<PrediccionResponseDTO>> obtenerPredicciones() {
                return ResponseEntity.ok(
                                prediccionGetService.obtenerPredicciones());
        }

        @GetMapping("/usuario/{id}")
        public ResponseEntity<List<PrediccionResponseDTO>> obtenerPorUsuario(
                        @PathVariable Long id) {
                return ResponseEntity.ok(
                                prediccionGetService.obtenerPrediccionesUsuario(id));
        }

        @GetMapping("/partido/{id}")
        public ResponseEntity<List<PrediccionResponseDTO>> obtenerPorPartido(
                        @PathVariable Long id) {
                return ResponseEntity.ok(
                                prediccionGetService.obtenerPrediccionesPartido(id));
        }

        @GetMapping("/usuario/{usuarioId}/fecha/{fechaId}")
        public ResponseEntity<List<PrediccionResponseDTO>> obtenerPrediccionesUsuario(
                        @PathVariable Long usuarioId,
                        @PathVariable Long fechaId) {

                return ResponseEntity.ok(
                                prediccionGetService.obtenerPrediccionesUsuarioYFecha(usuarioId, fechaId));
        }
}