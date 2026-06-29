package com.ProgIV.Prode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ProgIV.Prode.exceptions.CustomAccessDeniedHandler;
import com.ProgIV.Prode.exceptions.CustomAuthEntryPoint;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor

public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final CustomAuthEntryPoint customAuthEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                // CSRF desactivado (API REST)
                .csrf(csrf -> csrf.disable())

                // API stateless (JWT)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // manejo de errores 401 / 403
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(customAuthEntryPoint) // 401
                        .accessDeniedHandler(customAccessDeniedHandler) // 403
                )
                .authorizeHttpRequests(auth -> auth

                        // publicos
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/register").permitAll()

                        // USER + ADMIN: cada usuario edita su propio perfil
                        // (la validación de que sea SU id la hace el service)
                        .requestMatchers(HttpMethod.PUT, "/usuarios/*").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/auth/me").hasAnyRole("USER", "ADMIN")

                        // ADMIN: gestión completa de usuarios (listar, ver por id, crear, eliminar)
                        .requestMatchers("/usuarios/**").hasRole("ADMIN")

                        .requestMatchers("/partidos/create").hasRole("ADMIN")
                        .requestMatchers("/partidos/delete/**").hasRole("ADMIN")

                        // USER + ADMIN
                        .requestMatchers("/partidos/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/predicciones/**").hasAnyRole("USER", "ADMIN")

                        // todo lo demas requiere login
                        .anyRequest().authenticated())

                // filtro JWT
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // encoder de passwords
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}