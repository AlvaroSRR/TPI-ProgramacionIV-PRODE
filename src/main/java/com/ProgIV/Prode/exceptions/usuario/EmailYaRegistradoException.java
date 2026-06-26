package com.ProgIV.Prode.exceptions.usuario;

import com.ProgIV.Prode.exceptions.BusinessException;

public class EmailYaRegistradoException extends BusinessException{
    public EmailYaRegistradoException(String email) {
        super("El email ya se encuentra registrado: " + email);
    }
    public EmailYaRegistradoException() {
        super("El email ya se encuentra registrado");
    }
}
