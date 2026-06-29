package com.ProgIV.Prode.controllers.Patch;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ProgIV.Prode.features.dtos.request.PartidoUpdateDatosRequestDTO;
import com.ProgIV.Prode.features.dtos.response.PartidoUpdateResponseDTO;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.services.interfaces.partido.IPartidoUpdateService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/partidos")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN')")
public class PartidoUpdateController {

    private final IPartidoUpdateService partidoUpdateService;

    // @PutMapping
    // public ResponseEntity<PartidoResponseDTO> update(
    //         @Valid @RequestBody PartidoUpdateRequestDTO dto) {

    //     Partido partidoActualizado = partidoUpdateService.actualizarResultado(dto);

    //     PartidoResponseDTO response = PartidoResponseDTO.builder()
    //             .partidoId(partidoActualizado.getId())
    //             .equipoLocal(partidoActualizado.getEquipoLocal())
    //             .equipoVisitante(partidoActualizado.getEquipoVisitante())
    //             .golLocal(partidoActualizado.getGolLocal())
    //             .golVisitante(partidoActualizado.getGolVisitante())
    //             .resultado(partidoActualizado.getResultado())
    //             .build();

    //     return ResponseEntity.ok(response);
    // }

    @PatchMapping("/{id}")
    public ResponseEntity<PartidoUpdateResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PartidoUpdateDatosRequestDTO dto) {

        Partido partido = partidoUpdateService.actualizar(id, dto);

        PartidoUpdateResponseDTO response = PartidoUpdateResponseDTO.builder()
                .partidoId(partido.getId())
                .equipoLocal(partido.getEquipoLocal())
                .equipoVisitante(partido.getEquipoVisitante())
                .estadoPartido(partido.getEstadoPartido())
                .fecha(partido.getFecha())
                .horaInicio(partido.getHoraInicio())
                .build();

        return ResponseEntity.ok(response);
    }
}