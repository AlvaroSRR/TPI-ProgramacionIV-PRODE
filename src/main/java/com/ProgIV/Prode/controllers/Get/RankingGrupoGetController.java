package com.ProgIV.Prode.controllers.Get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.response.RankingResponseDTO;
import com.ProgIV.Prode.features.services.impl.ranking.RankingGrupoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class RankingGrupoGetController {

    private final RankingGrupoService rankingGrupoService;

    @GetMapping("/grupo/{grupoId}")
    public ResponseEntity<List<RankingResponseDTO>> obtenerRankingGrupo(
            @PathVariable Long grupoId) {

        return ResponseEntity.ok(
            rankingGrupoService.obtenerRankingGrupo(grupoId)
        );
    }
}