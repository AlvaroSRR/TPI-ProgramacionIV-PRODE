package com.ProgIV.Prode.exceptions.equipo;

import com.ProgIV.Prode.exceptions.BusinessException;

public class EquipoNoEncontradoException extends BusinessException {
    public EquipoNoEncontradoException(Long id) {
        super("No se encontró el equipo con id: " + id);
    }
}
