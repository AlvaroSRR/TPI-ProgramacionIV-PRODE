package com.ProgIV.Prode.features.services.impl.fecha;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.BusinessException;
import com.ProgIV.Prode.features.models.EstadoFecha;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.repositories.FechaRepository;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaUpdateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FechaUpdateService implements IFechaUpdateService {

    private final FechaRepository fechaRepository;
    private final PartidoRepository partidoRepository;

    @Override
    public Fecha update(Long id, String nombre) {

        Fecha fecha = fechaRepository.findByIdAndEliminadoFalse(id)
                .orElseThrow(() -> 
                    new BusinessException("Fecha no encontrada"));

        if (fecha.getEstado() != EstadoFecha.PROGRAMADA) {
            throw new BusinessException(
                "Solo se pueden modificar fechas PROGRAMADAS");
        }

        if (partidoRepository.existsByFechaId(id)) {
            throw new BusinessException(
                "La fecha posee partidos asociados");
        }

        fecha.setNombre(nombre);

        return fechaRepository.save(fecha);
    }
}