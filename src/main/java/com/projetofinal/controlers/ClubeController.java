package com.projetofinal.controlers;

import com.projetofinal.entities.Clube;
import com.projetofinal.services.ClubeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projetofinal.repositories.ClubeRepository;

@RestController
@RequestMapping("/clube")
public class ClubeController {

    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @PostMapping
    public ResponseEntity<?> postClube(@RequestBody @Valid   Clube clube) {
        return clubeService.salvarClube(clube);
    }

    @PutMapping
    public ResponseEntity<?> putClube(@RequestBody @Valid Clube clube) {
        return clubeService.editarClube(clube);
    }

}
