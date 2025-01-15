package com.projetofinal.repositories;

import com.projetofinal.entities.Clube;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {
    List<Clube> findByNome(@NotNull(message = "Nome nao pode ser nulo.") @Size(min = 2, message = "O nome do clube deve ter no minimo 2 caracteres.") @Valid String nome);
}
