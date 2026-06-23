package com.ProgIV.Prode.exceptions.pronostico;

import com.ProgIV.Prode.exceptions.BusinessException;

public class PronosticoFueraDeTiempoException extends BusinessException {

    public PronosticoFueraDeTiempoException(String message) {
        super(message);
    }

    public PronosticoFueraDeTiempoException() {
        super("Fuera del tiempo permitido para realizar predicciones");
    }
}
