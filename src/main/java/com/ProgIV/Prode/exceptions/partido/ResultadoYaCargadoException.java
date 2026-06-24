package com.ProgIV.Prode.exceptions.partido;

import com.ProgIV.Prode.exceptions.BusinessException;

public class ResultadoYaCargadoException extends BusinessException {

    public ResultadoYaCargadoException() {
        super("El resultado del partido ya fue cargado y no puede modificarse");
    }
}