package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.LoginRequestDTO;
import com.ProgIV.Prode.features.dtos.request.RegisterRequestDTO;
import com.ProgIV.Prode.features.dtos.response.LoginResponseDTO;
import com.ProgIV.Prode.features.dtos.response.RegisterResponseDTO;
import com.ProgIV.Prode.features.services.AuthRegisterService;
import com.ProgIV.Prode.features.services.interfaces.IAuthLoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthPostController {
    private final AuthRegisterService authRegisterService;
    private final IAuthLoginService authLoginService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(
            @RequestBody RegisterRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authRegisterService.register(dto));

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO dto) {

        return ResponseEntity.ok(authLoginService.login(dto));
    }

}
