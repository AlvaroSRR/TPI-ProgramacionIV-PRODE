package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.UnirseGrupoRequestDTO;
import com.ProgIV.Prode.features.services.impl.grupo.GrupoJoinService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER')")
public class UnirseGrupoPostController {

    private final GrupoJoinService grupoJoinService;

    @PostMapping("/unirse/{usuarioId}")
    public ResponseEntity<String> unirseGrupo(
            @PathVariable Long usuarioId,
            @RequestBody UnirseGrupoRequestDTO request) {
        grupoJoinService.unirse(
            usuarioId,
            request.getCodigoInvitacion()
        );
        
            return ResponseEntity.ok("Usuario unido al grupo exitosamente");
    }
}
