package com.projetofinal.services;
import com.projetofinal.exceptions.ClubeAlreadyExistsException;
import com.projetofinal.exceptions.ClubeNotFoundException;


import com.projetofinal.entities.Clube;
import com.projetofinal.repositories.ClubeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubeService {
    private final ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {

        this.clubeRepository = clubeRepository;
    }

    public Clube salvarClube(Clube clube) {
        List<Clube> clubes = clubeRepository.findByNomeContainingIgnoreCase(clube.getNome());
        if (!clubes.isEmpty()) {
            throw new ClubeAlreadyExistsException(clube.getNome()); //
        }
        return clubeRepository.save(clube);
    }

    public Clube editarClube(Long id, Clube clube) {
        Clube clubeExistente = clubeRepository.findById(id)
                .orElseThrow(() -> new ClubeNotFoundException(id));

        clubeExistente.setNome(clube.getNome());
        clubeExistente.setEstado(clube.getEstado());
        clubeExistente.setDataCriacao(clube.getDataCriacao());
        clubeExistente.setAtivo(clube.getAtivo());

        return clubeRepository.save(clubeExistente);
    }

    public void inativarClube(Long id) {
        Clube clubeRetorno = clubeRepository.findById(id)
                .orElseThrow(() -> new ClubeNotFoundException(id));
        clubeRetorno.setAtivo(false);
        clubeRepository.save(clubeRetorno);
    }
    public Clube findById(Long id) {
        return clubeRepository.findById(id)
                .orElseThrow(() -> new ClubeNotFoundException(id));
    }
    public Page<Clube> listarClube(String nome, String estado,Boolean ativo, Pageable pageable) {
        return clubeRepository.findByNomeContainingIgnoreCaseOrEstadoOrAtivo(nome,estado, ativo, pageable);
    }
}