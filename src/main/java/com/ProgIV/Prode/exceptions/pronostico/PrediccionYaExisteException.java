package com.ProgIV.Prode.exceptions.pronostico;

import com.ProgIV.Prode.exceptions.BusinessException;

public class PrediccionYaExisteException extends BusinessException {

    public PrediccionYaExisteException() {
        super("Ya existe una predicción para este usuario y partido");
    }
}
