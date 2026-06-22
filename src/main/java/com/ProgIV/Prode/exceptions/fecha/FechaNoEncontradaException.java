package com.ProgIV.Prode.exceptions.fecha;

import com.ProgIV.Prode.exceptions.BusinessException;

public class FechaNoEncontradaException extends BusinessException {
    public FechaNoEncontradaException(Long id) {
        super("No se encontró la fecha con id: " + id);
    }
}