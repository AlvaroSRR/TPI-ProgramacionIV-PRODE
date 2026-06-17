package com.ProgIV.Prode.features.services.impl.grupo;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.grupo.GrupoNoEncontradoException;
import com.ProgIV.Prode.features.models.Grupo;
import com.ProgIV.Prode.features.repositories.GrupoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GrupoFindByIdService {

    private final GrupoRepository grupoRepository;

    public Grupo execute(Long id) {

        return grupoRepository
                .findByIdAndActivoTrue(id)
                .orElseThrow(() ->
                        new GrupoNoEncontradoException(id));
    }
}