package com.ProgIV.Prode.features.services.impl.fecha;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.EstadoFecha;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.repositories.FechaRepository;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaGetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FechaGetService implements IFechaGetService {

    private final FechaRepository fechaRepository;

    // devuelve todas las fechas que no estén eliminadas y en el frontend se filtran por estado
    @Override
    public List<Fecha> listarFechas() {
        return fechaRepository.findAll()
                .stream()
                .filter(f -> !Boolean.TRUE.equals(f.getEliminado()))
                .toList();
    }

    @Override
    public List<Fecha> listarFechasPorEstado(EstadoFecha estado) {
        return fechaRepository.findAll()
                .stream()
                .filter(f -> !Boolean.TRUE.equals(f.getEliminado()))
                .filter(f -> f.getEstado() == estado)
                .toList();
    }
}