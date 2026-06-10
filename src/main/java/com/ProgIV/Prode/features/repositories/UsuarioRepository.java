package com.ProgIV.Prode.features.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProgIV.Prode.features.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByNombreUsuario(String nombreUsuario);
}
