package com.ProgIV.Prode.exceptions;

public class PrediccionBloqueadaException extends BusinessException {

    public PrediccionBloqueadaException() {
        super("Predicción bloqueada porque el partido ya ha comenzado o finalizado.");
    }

    public PrediccionBloqueadaException (String message) {
        super(message);
    }
}