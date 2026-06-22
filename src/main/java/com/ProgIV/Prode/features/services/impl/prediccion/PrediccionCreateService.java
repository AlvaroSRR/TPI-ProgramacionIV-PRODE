package com.ProgIV.Prode.features.services.impl.prediccion;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.dtos.request.PrediccionCreateRequestDTO;
import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.models.Prediccion;
import com.ProgIV.Prode.features.models.Usuario;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.repositories.PrediccionRepository;
import com.ProgIV.Prode.features.repositories.UsuarioRepository;
import com.ProgIV.Prode.features.services.interfaces.prediccion.IPrediccionCreateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrediccionCreateService implements IPrediccionCreateService {

    private final PrediccionRepository prediccionRepository;
    private final UsuarioRepository usuarioRepository;
    private final PartidoRepository partidoRepository;

    @Override
    public Prediccion guardarPrediccion(PrediccionCreateRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Partido partido = partidoRepository.findById(dto.getPartidoId())
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

        // RF5.1
        if (partido.getEstadoPartido() != EstadoPartido.POR_JUGARSE) {

            throw new RuntimeException(
                    "Solo se puede pronosticar partidos POR_JUGARSE");
        }

        OffsetDateTime limite =
                partido.getHoraInicio().minusMinutes(30);

        if (OffsetDateTime.now().isAfter(limite)) {

            throw new RuntimeException(
                    "El plazo para realizar predicciones ha expirado");
        }

        Prediccion prediccion =
                prediccionRepository
                        .findByUsuarioIdAndPartidoId(
                                usuario.getId(),
                                partido.getId())
                        .orElse(null);

        if (prediccion == null) {

            prediccion = new Prediccion();

            prediccion.setUsuario(usuario);
            prediccion.setPartido(partido);
            prediccion.setFechaPrediccion(
                    OffsetDateTime.now());
        }

        prediccion.setGolLocal(dto.getGolLocal());
        prediccion.setGolVisitante(dto.getGolVisitante());

        return prediccionRepository.save(prediccion);
    }
}