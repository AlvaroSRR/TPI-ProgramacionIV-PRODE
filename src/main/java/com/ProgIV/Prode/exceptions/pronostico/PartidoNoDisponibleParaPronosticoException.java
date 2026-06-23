package com.ProgIV.Prode.exceptions.pronostico;

import com.ProgIV.Prode.exceptions.BusinessException;

public class PartidoNoDisponibleParaPronosticoException extends BusinessException {
    
    public PartidoNoDisponibleParaPronosticoException() {
        super("No es posible registrar o modificar el pronóstico porque el partido no está disponible para pronosticar");
    }
}
