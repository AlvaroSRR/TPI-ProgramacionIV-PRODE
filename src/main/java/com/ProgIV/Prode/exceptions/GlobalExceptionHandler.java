package com.ProgIV.Prode.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(BusinessException.class)
        public ResponseEntity<String> handleBusinessException(
                        BusinessException ex) {

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(ex.getMessage());
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationException(
                        MethodArgumentNotValidException ex) {

                Map<String, String> errores = new HashMap<>();

                ex.getBindingResult()
                                .getFieldErrors()
                                .forEach(error -> errores.put(
                                                error.getField(),
                                                error.getDefaultMessage()));

                return ResponseEntity.badRequest().body(errores);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception ex) {

                return ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error interno del servidor");
        }
}
