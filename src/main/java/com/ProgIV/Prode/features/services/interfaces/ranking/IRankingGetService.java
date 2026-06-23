package com.ProgIV.Prode.features.services.interfaces.ranking;

import java.util.List;

import com.ProgIV.Prode.features.dtos.response.RankingResponseDTO;

public interface IRankingGetService {
    List<RankingResponseDTO> obtenerRankingGlobal();
}
