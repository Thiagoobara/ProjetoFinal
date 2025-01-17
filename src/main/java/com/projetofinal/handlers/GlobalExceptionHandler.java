package com.projetofinal.handlers;


import com.projetofinal.exceptions.ClubeAlreadyExistsException;
import com.projetofinal.exceptions.ClubeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ClubeAlreadyExistsException.class)
    public ResponseEntity<String> handleClubeAlreadyExistsException(ClubeAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
    @ExceptionHandler(ClubeNotFoundException.class)
    public ResponseEntity<String> handleClubeNotFoundException(ClubeNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}