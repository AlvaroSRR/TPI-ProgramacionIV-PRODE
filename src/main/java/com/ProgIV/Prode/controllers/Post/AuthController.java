package com.ProgIV.Prode.controllers.Post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProgIV.Prode.features.dtos.request.LoginRequestDTO;
import com.ProgIV.Prode.features.dtos.response.LoginResponseDTO;
import com.ProgIV.Prode.features.services.interfaces.IAuthLoginService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5174") // arreglar esto
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final IAuthLoginService authLoginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO dto) {

        return ResponseEntity.ok(authLoginService.login(dto));
    }
}
