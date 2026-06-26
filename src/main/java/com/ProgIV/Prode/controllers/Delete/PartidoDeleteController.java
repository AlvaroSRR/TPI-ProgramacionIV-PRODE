package com.ProgIV.Prode.controllers.Delete;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.response.ApiResponse;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoDeleteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/partidos")
@PreAuthorize("hasAnyRole('ADMIN')")
public class PartidoDeleteController {

    private final IPartidoDeleteService partidoDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {

        partidoDeleteService.eliminarPartido(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Partido eliminado correctamente", null));
    }
}
