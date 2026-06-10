package com.ProgIV.Prode.features.models;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
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
public class Prediccion {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPartido", nullable = false)
    private Partido partido;

    @NotNull
    private OffsetDateTime fechaPrediccion; // formato UTC

    @NotNull
    private Integer golLocal;

    @NotNull
    private Integer golVisitante;

    private Integer puntosObtenidos = 0;

    private Boolean esTendencia = false;

    private Boolean esExacta = false;

}
