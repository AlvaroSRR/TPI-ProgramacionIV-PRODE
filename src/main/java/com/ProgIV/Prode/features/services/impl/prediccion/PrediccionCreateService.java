package com.ProgIV.Prode.features.services.impl.prediccion;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.exceptions.partido.PartidoNoEncontradoException;
import com.ProgIV.Prode.exceptions.pronostico.PronosticoFueraDeTiempoException;
import com.ProgIV.Prode.exceptions.usuario.UsuarioNoEncontradoException;
import com.ProgIV.Prode.features.dtos.request.PrediccionCreateRequestDTO;
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
                .orElseThrow(() -> new UsuarioNoEncontradoException(dto.getUsuarioId()));

        Partido partido = partidoRepository.findById(dto.getPartidoId())
                .orElseThrow(() -> new PartidoNoEncontradoException(dto.getPartidoId()));

        validarReglaBloqueo(partido);

        Prediccion prediccion = prediccionRepository
                .findByUsuarioAndPartido(usuario, partido)
                .orElse(null);

        if (prediccion == null) {
            prediccion = new Prediccion();
            prediccion.setUsuario(usuario);
            prediccion.setPartido(partido);
            prediccion.setFechaPrediccion(OffsetDateTime.now());
        }

        prediccion.setGolLocal(dto.getGolLocal());
        prediccion.setGolVisitante(dto.getGolVisitante());

        return prediccionRepository.save(prediccion);
    }

    private void validarReglaBloqueo(Partido partido) {

        if (partido.getHoraInicio() == null) {
            throw new IllegalStateException("El partido no tiene hora de inicio");
        }

        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime limite = partido.getHoraInicio().minusMinutes(30);

        if (now.isAfter(limite)) {
            throw new PronosticoFueraDeTiempoException();
        }
    }
}