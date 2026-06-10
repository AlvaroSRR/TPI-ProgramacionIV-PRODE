package com.ProgIV.Prode.exceptions.partido;

import com.ProgIV.Prode.exceptions.BusinessException;

public class PartidoNoEncontradoException extends BusinessException {

    public PartidoNoEncontradoException(Long id) {
        super("No se encontró el partido con id: " + id);
    }
    
}
