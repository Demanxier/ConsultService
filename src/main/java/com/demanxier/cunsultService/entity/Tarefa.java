package com.demanxier.cunsultService.entity;

import com.demanxier.cunsultService.entity.enums.StatusTarefa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    private LocalDate vencimento;

    private LocalDateTime dataConcluido;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_cliente", nullable = true)
    @JsonBackReference //Impede a serialização recursiva entre Cliente e Ticket
    private Cliente cliente;

    @OneToMany(mappedBy = "tarefa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"tarefa"})
    private List<CardTarefa> cards = new ArrayList<>();

    // @OneToMany(mappedBy = "id_atendimento") --> Errei ao relacionar errado.
    //O mappedBy é para indicar a relação um para muitos entre ticket e atendimento
    @OneToMany(mappedBy = "tarefa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"tarefa"}) //Evita ciclos
    private List<Atendimento> atendimento = new ArrayList<>();

}
