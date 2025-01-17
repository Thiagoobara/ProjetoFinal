package com.projetofinal.entities;

import com.projetofinal.enums.Estado;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class  Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotNull(message = "Nome nao pode ser nulo.")
    @Size(min = 2, message = "O nome do clube deve ter no minimo 2 caracteres.")
    @Valid
    private String nome;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Estado nao pode ser nulo.")
    @Valid
    private Estado estado;
    @NotNull(message = "Data de criacao nao pode ser nulo.")
    @PastOrPresent(message = "Data nao pode ser superior a atual!")
    @Valid
    private LocalDate dataCriacao;
    @NotNull(message = "Status nao pode ser nulo.")
    @Valid
    private Boolean ativo;

    @OneToMany(mappedBy = "clube1",cascade = CascadeType.ALL)
    private List<Partida> partidasClube1;

    @OneToMany(mappedBy = "clube2", cascade = CascadeType.ALL)
    private List<Partida> partidasClube2;

}
