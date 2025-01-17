package com.projetofinal.entities;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data

public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clube_1_id", nullable = false)
    private Clube clube1;

    @ManyToOne
    @JoinColumn(name = "clube_2_id", nullable = false)
    private Clube clube2;

    @NotNull(message = "Clube 1 não pode ser nulo")
    @Min(value = 0, message = "Resultado não pode ser negativo")
    private Integer resultadoClube1;

    @NotNull(message = "Clube 2 não pode ser nulo")
    @Min(value = 0, message = "Resultado não pode ser negativo")
    private Integer resultadoClube2;

    @Future(message = "A data da partida não pode ser no futuro")
    private LocalDate dataPartida;

}
