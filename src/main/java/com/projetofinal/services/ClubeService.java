package com.projetofinal.services;

import com.projetofinal.entities.Clube;
import com.projetofinal.repositories.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubeService {
    final ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    public ResponseEntity<?> salvarClube(Clube clube){
        List<Clube> clubes = clubeRepository.findByNome(clube.getNome());
        clube.getNome();
        if(!clubes.isEmpty()){
            return new ResponseEntity<>("Ja existe clube com o nome " + clube.getNome(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(clubeRepository.save(clube), HttpStatus.CREATED);
    }
    public ResponseEntity<?> editarClube(Clube clube) {
        Optional<Clube> clubeRetorno = clubeRepository.findById(clube.getId());
        if(!clubeRetorno.isPresent()){
            return new ResponseEntity<>("O clube não existe " , HttpStatus.BAD_REQUEST);
        }
         return new ResponseEntity<>(clubeRepository.save(clube), HttpStatus.OK);
    }
}