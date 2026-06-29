package com.ProgIV.Prode.exceptions.partido;

import com.ProgIV.Prode.exceptions.BusinessException;

public class PartidoNoModificableException extends BusinessException {

     public PartidoNoModificableException() {
        super("No es posible modificar el partido porque faltan menos de 30 minutos para su inicio ");
    }
    
}
