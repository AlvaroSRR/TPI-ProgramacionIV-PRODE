package com.ProgIV.Prode.controllers.Delete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoDeleteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/grupos")
@AllArgsConstructor
public class GrupoDeleteController {

private final IGrupoDeleteService grupoDeleteService;

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(
        @PathVariable Long id) {

    grupoDeleteService.delete(id);
    return ResponseEntity.noContent().build();
}

}
