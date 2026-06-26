package com.ProgIV.Prode.features.dtos.response;

import java.time.OffsetDateTime;

import com.ProgIV.Prode.features.models.Equipo;
import com.ProgIV.Prode.features.models.EstadoPartido;
import com.ProgIV.Prode.features.models.Fecha;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PartidoUpdateResponseDTO {
    
            private Long partidoId;
            private Equipo equipoLocal;
            private Equipo equipoVisitante;
            private EstadoPartido estadoPartido;
            private Fecha fecha;
           private OffsetDateTime horaInicio;
}
