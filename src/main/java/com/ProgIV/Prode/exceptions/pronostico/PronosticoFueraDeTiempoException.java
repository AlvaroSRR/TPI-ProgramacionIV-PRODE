package com.ProgIV.Prode.exceptions.pronostico;

import com.ProgIV.Prode.exceptions.BusinessException;

public class PronosticoFueraDeTiempoException extends BusinessException {

    public PronosticoFueraDeTiempoException() {
        super("No es posible registrar o modificar el pronóstico porque el tiempo límite ha expirado");
    }
    
}
