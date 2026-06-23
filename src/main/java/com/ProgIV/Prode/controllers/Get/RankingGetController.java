package com.ProgIV.Prode.controllers.Get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.response.RankingResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.ranking.IRankingGetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class RankingGetController {
    
    private final IRankingGetService rankingGetService;

    @GetMapping
    public ResponseEntity<List<RankingResponseDTO>> obtenerRanking() {

        return ResponseEntity.ok(
                rankingGetService.obtenerRankingGlobal()
        );
    }
}
