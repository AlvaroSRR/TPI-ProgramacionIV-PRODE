package com.ProgIV.Prode.features.dtos.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponseDTO {
    private String token;
}
