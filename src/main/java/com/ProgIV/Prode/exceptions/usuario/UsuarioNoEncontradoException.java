package com.ProgIV.Prode.exceptions.usuario;

import com.ProgIV.Prode.exceptions.BusinessException;

public class UsuarioNoEncontradoException extends BusinessException {
    public UsuarioNoEncontradoException(Long id) {
        super("No se encontró el usuario con id: " + id);
    }

    public UsuarioNoEncontradoException(String email) {
        super("No se encontró el usuario con email: " + email);
    }

}
