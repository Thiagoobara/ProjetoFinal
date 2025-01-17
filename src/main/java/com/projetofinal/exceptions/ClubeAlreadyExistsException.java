package com.projetofinal.exceptions;

public class ClubeAlreadyExistsException extends RuntimeException {
    public ClubeAlreadyExistsException(String nome) {
        super("Já existe um clube com esse nome: " + nome);
    }
}