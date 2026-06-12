package com.ProgIV.Prode.features.services.impl.usuario;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;
import com.ProgIV.Prode.features.services.interfaces.usuario.IUsuarioDeleteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioDeleteService implements IUsuarioDeleteService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioFindByIdService usuarioFindByIdService;

    @Override
    public void delete(Long id) {

        Usuario usuario = usuarioFindByIdService.execute(id);

        usuario.setActivo(false); // SOFT DELETE

        usuarioRepository.save(usuario);
    }
}
