package com.ProgIV.Prode.features.services.impl.prediccion;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.partido.PartidoNoEncontradoException;
import com.ProgIV.Prode.exceptions.usuario.UsuarioNoEncontradoException;
import com.ProgIV.Prode.features.dtos.response.PrediccionResponseDTO;
import com.ProgIV.Prode.features.mappers.PrediccionMapper;
import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.models.Prediccion;
import com.ProgIV.Prode.features.models.Rol;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.repositories.PrediccionRepository;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;
import com.ProgIV.Prode.features.services.interfaces.prediccion.IPrediccionGetService;

import lombok.RequiredArgsConstructor;
import java.time.Clock;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PrediccionGetService implements IPrediccionGetService {

    private final PrediccionRepository prediccionRepository;
    private final PrediccionMapper prediccionMapper;
    private final UsuarioRepository usuarioRepository;
    private final PartidoRepository partidoRepository;
    private final Clock clock;

    @Override
    public List<PrediccionResponseDTO> obtenerPredicciones() {
        return prediccionRepository
                .findByPartido_EstadoPartido(EstadoPartido.FINALIZADO)
                .stream()
                .map(prediccionMapper::toDTO)
                .toList();
    }

    @Override
    public List<PrediccionResponseDTO> obtenerPrediccionesUsuario(Long usuarioId) {
        return prediccionRepository
                .findByUsuarioIdAndPartido_EstadoPartido(
                        usuarioId,
                        EstadoPartido.FINALIZADO)
                .stream()
                .map(prediccionMapper::toDTO)
                .toList();
    }

    @Override
    public List<PrediccionResponseDTO> obtenerPrediccionesPartido(Long partidoId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNoEncontradoException(email));

        Partido partido = partidoRepository.findById(partidoId)
                .orElseThrow(() -> new PartidoNoEncontradoException(partidoId));

        List<Prediccion> predicciones;

        // ADMIN
        if (usuario.getRol() == Rol.ADMIN) {
            predicciones = prediccionRepository.findByPartidoId(partidoId);
        }

        // PARTIDO FINALIZADO
        else if (partido.getEstadoPartido() == EstadoPartido.FINALIZADO) {
            predicciones = prediccionRepository.findByPartidoId(partidoId);
        }

        // OTROS CASOS
        else {
            OffsetDateTime limite = partido.getHoraInicio().minusMinutes(30);
            boolean bloqueado = OffsetDateTime.now(clock).isAfter(limite);

            if (bloqueado) {
                predicciones = prediccionRepository.findByPartidoId(partidoId);
            } else {
                predicciones = prediccionRepository
                        .findByUsuarioAndPartido(usuario, partido)
                        .map(List::of)
                        .orElse(List.of());
            }
        }

        return predicciones.stream()
                .map(prediccionMapper::toDTO)
                .toList();
    }

    @Override
    public List<PrediccionResponseDTO> obtenerPrediccionesUsuarioYFecha(Long usuarioId, Long fechaId) {

        OffsetDateTime ahora = OffsetDateTime.now(clock);  
        return prediccionRepository
                .findPrediccionesUsuario(usuarioId, fechaId, ahora)
                .stream()
                .map(prediccionMapper::toDTO)
                .toList();
    }
}