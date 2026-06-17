package com.ProgIV.Prode.features.services.impl.usuario;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.usuario.UsuarioNoEncontradoException;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioFindByIdService {
    private final UsuarioRepository usuarioRepository;

    public Usuario execute(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));
    }

}
