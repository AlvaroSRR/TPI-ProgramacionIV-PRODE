package com.ProgIV.Prode.exceptions.usuario;

import com.ProgIV.Prode.exceptions.BusinessException;

public class UsuarioYaTieneGrupoException extends BusinessException {
     public UsuarioYaTieneGrupoException() {
        super("Ya tenés un grupo propio creado");
    }
}