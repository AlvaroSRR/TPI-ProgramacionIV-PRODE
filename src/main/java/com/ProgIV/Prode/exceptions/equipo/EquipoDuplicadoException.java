package com.ProgIV.Prode.exceptions.equipo;

import com.ProgIV.Prode.exceptions.BusinessException;

public class EquipoDuplicadoException extends BusinessException {

    public EquipoDuplicadoException(String nombre) {
        super("Ya existe un equipo con nombre: " + nombre);
    }
    
}
