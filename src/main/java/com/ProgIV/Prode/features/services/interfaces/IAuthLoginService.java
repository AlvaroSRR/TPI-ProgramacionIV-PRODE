package com.ProgIV.Prode.features.services.interfaces;

import com.ProgIV.Prode.features.dtos.request.LoginRequestDTO;
import com.ProgIV.Prode.features.dtos.response.LoginResponseDTO;

public interface IAuthLoginService {
    LoginResponseDTO login(LoginRequestDTO dto);
}
