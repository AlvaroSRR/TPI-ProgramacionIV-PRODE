package com.ProgIV.Prode.features.services.interfaces.fecha;

import com.ProgIV.Prode.features.models.Fecha;

public interface IFechaUpdateService {

    Fecha update(Long id, String nombre);
}