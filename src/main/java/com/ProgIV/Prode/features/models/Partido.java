package com.ProgIV.Prode.features.models;

import java.time.LocalTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;


// terminar de definir
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
    @NotNull
    private Integer golLocal;
    @NotNull
    private Integer golVisitante;

    @NotNull
    private EstadoPartido estadoPartido;
    @NotNull
    private String resultado;
    
    private Fecha fecha;
    private LocalTime horaInicio;
}
