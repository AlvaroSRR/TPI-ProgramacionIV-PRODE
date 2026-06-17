package com.ProgIV.Prode.exceptions.grupo;

import com.ProgIV.Prode.exceptions.BusinessException;

public class GrupoNoEncontradoException extends BusinessException {

    public GrupoNoEncontradoException(Long id) {
        super("No se encontró el grupo con id: " + id);
    }
    
}
