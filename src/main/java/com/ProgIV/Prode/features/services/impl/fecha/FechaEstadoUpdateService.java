package com.ProgIV.Prode.features.services.impl.fecha;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.EstadoFecha;
import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Fecha;
import com.ProgIV.Prode.features.models.Partido;
import com.ProgIV.Prode.features.repositories.FechaRepository;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.interfaces.fecha.IFechaEstadoUpdateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FechaEstadoUpdateService implements IFechaEstadoUpdateService {
    
     private final FechaRepository fechaRepository;
     private final PartidoRepository partidoRepository;

        @Override
        public void iniciarEstadoFecha(Long id) {
                Fecha fecha = fechaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Fecha no encontrada"));

                fecha.setEstado(EstadoFecha.EN_JUEGO);
                fechaRepository.save(fecha);
        }
        
        @Override
        public void finalizarEstadoFecha(Long id) {

        List<Partido> partidos = partidoRepository.findByFechaId(id);

        boolean todosFinalizados = partidos.stream()
                .allMatch(partido -> partido.getEstadoPartido() == EstadoPartido.FINALIZADO);

        if (!todosFinalizados) {
                return; // No hace nada, la fecha sigue igual
        }

        Fecha fecha = fechaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fecha no encontrada"));

        fecha.setEstado(EstadoFecha.FINALIZADA);
        fechaRepository.save(fecha);
        }
}
