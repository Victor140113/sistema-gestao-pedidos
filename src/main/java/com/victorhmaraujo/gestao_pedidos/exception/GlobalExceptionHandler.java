package com.victorhmaraujo.gestao_pedidos.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarErroValidacao(MethodArgumentNotValidException exception){

        Map<String, String> resposta = new HashMap<>();

        for(FieldError error : exception.getBindingResult().getFieldErrors()){
            resposta.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(400).body(resposta);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<String> resourceAlreadyExists(ResourceAlreadyExistsException exception){
        return ResponseEntity.status(409).body(exception.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFound(ResourceNotFoundException exception){
        return ResponseEntity.status(404).body(exception.getMessage());
    }
}
