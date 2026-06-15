package com.ProgIV.Prode.features.services.impl.usuario;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;
import com.ProgIV.Prode.features.services.interfaces.usuario.IUsuarioRestoreService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioRestoreService implements IUsuarioRestoreService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioFindByIdService usuarioFindByIdService;

    @Override
    public void restore(Long id) {

        Usuario usuario = usuarioFindByIdService.execute(id);

        usuario.setActivo(true);

        usuarioRepository.save(usuario);
    }
}
