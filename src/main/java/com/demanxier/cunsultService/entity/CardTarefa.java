package com.demanxier.cunsultService.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_card_tarefa")
public class CardTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;

    private LocalDateTime criadoEm;

    private LocalDateTime atualzadoEm;

    @ManyToOne
    @JoinColumn(name = "id_tarefa")
    @JsonBackReference
    private Tarefa tarefa;
}
