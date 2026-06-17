package com.ProgIV.Prode.controllers.Get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoGetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/grupos")
@AllArgsConstructor
public class GrupoGetController {

    private final IGrupoGetService grupoGetService;

    @GetMapping
    public ResponseEntity<List<GrupoResponseDTO>> getAll() {
        return ResponseEntity.ok(grupoGetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoResponseDTO> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                grupoGetService.getById(id));
    }

}