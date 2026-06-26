package com.ProgIV.Prode.features.services.impl.fecha;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.request.FechaCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.FechaResponseDTO;
import com.ProgIV.Prode.features.mappers.FechaMapper;
import com.ProgIV.Prode.features.models.EstadoFecha;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.repositories.FechaRepository;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaCreateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FechaCreateService implements IFechaCreateService {
    
    private final FechaRepository fechaRepository;
    private final FechaMapper fechaMapper;

    @Override
    public FechaResponseDTO crearFecha(FechaCreateRequestDTO dto) {

        Fecha fecha = new Fecha();
        fecha.setNombre(dto.getNombre());
        fecha.setEstado(EstadoFecha.PROGRAMADA);
        fecha.setEliminado(false);

        Fecha saved = fechaRepository.save(fecha);

        return fechaMapper.toDTO(saved);
    }
}