package com.ProgIV.Prode.exceptions.grupo;

import com.ProgIV.Prode.exceptions.BusinessException;

public class CodigoInvitacionInvalidoException extends BusinessException {

    public CodigoInvitacionInvalidoException() {
        super("El código de invitación es inválido");
    }
    
}
