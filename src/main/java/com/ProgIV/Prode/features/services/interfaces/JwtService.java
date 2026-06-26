package com.ProgIV.Prode.features.services.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

import com.ProgIV.Prode.features.models.Usuario;

public interface JwtService {
    String generateToken(Usuario usuario);
    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
}
