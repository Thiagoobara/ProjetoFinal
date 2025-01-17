package com.projetofinal.exceptions;


public class ClubeNotFoundException extends RuntimeException {
    public ClubeNotFoundException(long id) {
        super("Clube com id " + id + " não encontrado");
    }
}