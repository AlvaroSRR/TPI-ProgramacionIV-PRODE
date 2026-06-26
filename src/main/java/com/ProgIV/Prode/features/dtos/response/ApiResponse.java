package com.ProgIV.Prode.features.dtos.response;

public record ApiResponse<T>(
        String message,
        T data
) {}