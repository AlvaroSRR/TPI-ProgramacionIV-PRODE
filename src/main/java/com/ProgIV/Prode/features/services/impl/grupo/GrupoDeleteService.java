package com.ProgIV.Prode.features.services.impl.grupo;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Grupo;
import com.ProgIV.Prode.features.repositories.GrupoRepository;
import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoDeleteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GrupoDeleteService
        implements IGrupoDeleteService {

    private final GrupoFindByIdService grupoFindByIdService;
    private final GrupoRepository grupoRepository;

    @Override
    public void delete(Long id) {

        Grupo grupo =
                grupoFindByIdService.execute(id);

        grupo.setActivo(false);

        grupoRepository.save(grupo);
    }
}