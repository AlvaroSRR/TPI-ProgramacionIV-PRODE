package com.ProgIV.Prode.features.services.interfaces.fecha;

import java.util.List;

import com.ProgIV.Prode.features.models.EstadoFecha;
import com.ProgIV.Prode.features.models.Fecha;

public interface IFechaGetService {

    List<Fecha> listarFechas();
    List<Fecha> listarFechasPorEstado(EstadoFecha estado);
}
