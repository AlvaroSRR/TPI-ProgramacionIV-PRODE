package com.ProgIV.Prode.features.services.impl.ranking;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.response.RankingResponseDTO;
import com.ProgIV.Prode.features.repositories.PrediccionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankingGrupoService {
    
    private final PrediccionRepository prediccionRepository;
    
    public List<RankingResponseDTO> obtenerRankingGrupo(Long grupoId) {
        return prediccionRepository.obtenerRankingGrupo(grupoId);
    }
}
