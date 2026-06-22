package com.ProgIV.Prode.features.services.impl.fecha;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.repositories.FechaRepository;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaDeleteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FechaDeleteService implements IFechaDeleteService {

    private final FechaRepository fechaRepository;

    @Override
    public void eliminarFecha(Long id) {

        Fecha fecha = fechaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fecha no encontrada"));

        // para cuando tengamos partidos
        if (fecha.getEliminado()) {
            throw new RuntimeException("La fecha ya está eliminada");
        }


        fecha.setEliminado(true);
        fechaRepository.save(fecha);
    }
}