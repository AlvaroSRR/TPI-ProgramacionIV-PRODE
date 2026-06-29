package com.ProgIV.Prode.features.services.impl.fecha;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.BusinessException;
import com.ProgIV.Prode.exceptions.fecha.FechaNoEncontradaException;
import com.ProgIV.Prode.features.models.EstadoFecha;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.repositories.FechaRepository;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaDeleteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FechaDeleteService implements IFechaDeleteService {

    private final FechaRepository fechaRepository;
    private final PartidoRepository partidoRepository;

    @Override
    public void eliminarFecha(Long id) {

        Fecha fecha = fechaRepository.findById(id)
                .orElseThrow(() -> new FechaNoEncontradaException(id));

        if (fecha.getEstado() != EstadoFecha.PROGRAMADA) {
            throw new BusinessException(
                    "Solo se pueden eliminar fechas en estado PROGRAMADA");
        }

        if (partidoRepository.existsByFechaId(id)) {
            throw new BusinessException(
                    "No se puede eliminar la fecha porque tiene partidos asociados");
        }

        fecha.setEliminado(true);
        fechaRepository.save(fecha);
    }
}