package com.ProgIV.Prode.features.services.impl.ranking;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.response.RankingResponseDTO;
import com.ProgIV.Prode.features.repositories.PrediccionRepository;
import com.ProgIV.Prode.features.services.interfaces.ranking.IRankingGetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankingGlobalService implements IRankingGetService {

    private final PrediccionRepository prediccionRepository;

    @Override
    public List<RankingResponseDTO> obtenerRankingGlobal() {
        return prediccionRepository.obtenerRankingGlobal();
    }
}
