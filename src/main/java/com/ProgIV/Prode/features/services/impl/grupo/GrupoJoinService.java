package com.ProgIV.Prode.features.services.impl.grupo;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Grupo;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.GrupoRepository;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrupoJoinService {

    private final UsuarioRepository usuarioRepository;
    private final GrupoRepository grupoRepository;

    @Transactional
    public void unirse(Long usuarioId, String codigo) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Grupo grupo = grupoRepository.findByCodigoInvitacion(codigo)
                .orElseThrow(() -> new RuntimeException("Código inválido"));

        if (usuario.getGrupos().contains(grupo)) {
            throw new RuntimeException("Ya pertenecés al grupo");
        }

        usuario.getGrupos().add(grupo);

        usuarioRepository.save(usuario);
    }
}
