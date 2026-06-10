package com.ProgIV.Prode.features.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombreUsuario;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING) //guardamos el rol como texto en la bd
    private Rol rol;
    
    private Long idGrupoPropio;

    // Relación con grupos
    @ManyToMany
    @JoinTable(name = "usuarioXgrupo", 
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private Set<Grupo> grupos = new HashSet<>();
}