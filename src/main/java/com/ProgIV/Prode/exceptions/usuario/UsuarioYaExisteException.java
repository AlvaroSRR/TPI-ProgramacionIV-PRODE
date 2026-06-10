package com.ProgIV.Prode.exceptions.usuario;

import com.ProgIV.Prode.exceptions.BusinessException;

public class UsuarioYaExisteException extends BusinessException {
    public UsuarioYaExisteException(String nombre) {
        super("Ya existe un usuario con nombre: " + nombre);
    }
}
