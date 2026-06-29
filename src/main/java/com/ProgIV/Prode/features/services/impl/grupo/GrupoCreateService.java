package com.ProgIV.Prode.features.services.impl.grupo;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.grupo.GrupoYaExisteException;
import com.ProgIV.Prode.exceptions.usuario.UsuarioNoEncontradoException;
import com.ProgIV.Prode.exceptions.usuario.UsuarioYaTieneGrupoException;
import com.ProgIV.Prode.features.dtos.request.GrupoCreateRequestDTO;
import com.ProgIV.Prode.features.dtos.response.GrupoResponseDTO;
import com.ProgIV.Prode.features.mappers.GrupoMapper;
import com.ProgIV.Prode.features.models.Grupo;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.GrupoRepository;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;
import com.ProgIV.Prode.features.services.interfaces.grupo.IGrupoCreateService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GrupoCreateService implements IGrupoCreateService {

        private final GrupoRepository grupoRepository;
        private final UsuarioRepository usuarioRepository;
        private final GrupoMapper grupoMapper;

        @Override
        @Transactional
        public GrupoResponseDTO create(GrupoCreateRequestDTO dto, Long usuarioId) {

                Usuario usuario = usuarioRepository.findById(usuarioId)
                                .orElseThrow(() -> new UsuarioNoEncontradoException(usuarioId));

                if (usuario.getIdGrupoPropio() != null) {
                        throw new UsuarioYaTieneGrupoException();
                }

                if (grupoRepository.existsByNombre(dto.getNombre())) {
                        throw new GrupoYaExisteException(dto.getNombre());
                }

                String codigo = UUID.randomUUID()
                                .toString()
                                .substring(0, 6)
                                .toUpperCase();

                Grupo grupo = grupoMapper.toEntity(dto, codigo);
                Grupo guardado = grupoRepository.save(grupo);

                // El creador queda como dueño y también como miembro del grupo
                usuario.setIdGrupoPropio(guardado.getId());
                usuario.getGrupos().add(guardado);
                usuarioRepository.save(usuario);

                return grupoMapper.toResponseDTO(guardado);
        }
}