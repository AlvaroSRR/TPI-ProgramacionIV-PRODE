package com.ProgIV.Prode.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(BusinessException.class)
        public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {

                ErrorResponse response = new ErrorResponse(
                                "BUSINESS_ERROR",
                                ex.getMessage(),
                                HttpStatus.BAD_REQUEST.value(),
                                System.currentTimeMillis());

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(response);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

                String message = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .findFirst()
                                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                                .orElse("Error de validación");

                ErrorResponse response = new ErrorResponse(
                                "VALIDATION_ERROR",
                                message,
                                HttpStatus.BAD_REQUEST.value(),
                                System.currentTimeMillis());

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(response);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleException(Exception ex) {

                ErrorResponse response = new ErrorResponse(
                                "INTERNAL_ERROR",
                                "Error interno del servidor",
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                System.currentTimeMillis());

                return ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(response);
        }
}
