package com.ProgIV.Prode.features.dtos.request;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PartidoUpdateDatosRequestDTO {

    @NotNull
    private Long equipoLocalId;

    @NotNull
    private Long equipoVisitanteId;

    @NotNull
    private Long fechaId;

    @NotNull
    private OffsetDateTime horaInicio;
}