package com.ProgIV.Prode.features.models;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idLocal", nullable = false)
    private Equipo equipoLocal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idVisitante", nullable = false)
    private Equipo equipoVisitante;

    private Integer golLocal;

    private Integer golVisitante;

    @Enumerated(EnumType.STRING)
    private EstadoPartido estadoPartido = EstadoPartido.POR_JUGARSE;

    private String resultado;

    private boolean resultadoCargado;

    private boolean puntosCalculados;

    @ManyToOne
    @JoinColumn(name = "id_Fecha", nullable = false)
    private Fecha fecha;

    @NotNull
    private OffsetDateTime horaInicio; // formato UTC

    @Column(nullable = false)
    private boolean eliminado;
}
