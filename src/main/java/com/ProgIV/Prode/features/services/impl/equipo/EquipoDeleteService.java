package com.ProgIV.Prode.features.services.impl.equipo;

import org.springframework.stereotype.Service;

import com.ProgIV.Prode.features.models.Equipo;
import com.ProgIV.Prode.features.repositories.EquipoRepository;
import com.ProgIV.Prode.features.repositories.PartidoRepository;
import com.ProgIV.Prode.features.services.interfaces.equipo.IEquipoDeleteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipoDeleteService implements IEquipoDeleteService {

    private final EquipoRepository equipoRepository;
    private final PartidoRepository partidoRepository;

    @Override
    public void delete(Long id) {

        Equipo equipo = equipoRepository.findByIdAndEliminadoFalse(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));


        
        if (partidoRepository.existsByEquipoLocalIdOrEquipoVisitanteId(id, id)) {
            throw new RuntimeException(
                    "No se puede eliminar el equipo porque está asociado a uno o más partidos");
        }

        equipo.setEliminado(true);

        equipoRepository.save(equipo);
    }
}