package com.projetofinal.controllers;

import com.projetofinal.entities.Clube;
import com.projetofinal.services.ClubeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubes")
public class ClubeController {
    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @PostMapping
    public ResponseEntity<Clube> criarClube(@Valid @RequestBody Clube clube) {
        Clube novoClube = clubeService.salvarClube(clube);
        return new ResponseEntity<>(novoClube, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clube> atualizarClube(@PathVariable Long id, @Valid @RequestBody Clube clube) {
        Clube clubeAtualizado = clubeService.editarClube(id, clube);
        return new ResponseEntity<>(clubeAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> inativarClube(@PathVariable Long id) {
        clubeService.inativarClube(id);
        return new ResponseEntity<>("Clube inativado com sucesso", HttpStatus.OK);
    }

}