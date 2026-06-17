package com.ProgIV.Prode.exceptions.grupo;

import com.ProgIV.Prode.exceptions.BusinessException;

public class GrupoYaExisteException extends BusinessException {

    public GrupoYaExisteException(String nombre) {
        super("Ya existe un grupo con el nombre: " + nombre);
    }

}
