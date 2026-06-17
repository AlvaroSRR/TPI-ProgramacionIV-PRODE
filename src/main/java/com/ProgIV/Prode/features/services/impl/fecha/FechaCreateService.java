package com.ProgIV.Prode.features.services.impl.fecha;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.request.FechaCreateRequestDTO;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.repositories.FechaRepository;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaCreateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FechaCreateService implements IFechaCreateService {

    private final FechaRepository fechaRepository;

    @Override
    public Fecha crearFecha(FechaCreateRequestDTO dto) {

        Fecha fecha = new Fecha();
        fecha.setNombre(dto.getNombre());
        fecha.setEliminado(false);

        return fechaRepository.save(fecha);
    }
}