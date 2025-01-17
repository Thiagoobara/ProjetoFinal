package com.projetofinal.repositories;

import com.projetofinal.entities.Clube;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {
    List<Clube> findByNomeContainingIgnoreCase(String nome);
    Page<Clube> findByNomeContainingIgnoreCaseOrEstadoOrAtivo(String nome, String estado, Boolean ativo, Pageable pageable);
}