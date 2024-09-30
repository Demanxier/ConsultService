package com.demanxier.cunsultService.entity;

import com.demanxier.cunsultService.exception.StatusAtendimento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusAtendimento status;

    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "id_consultor")
    private Consultor consultor;
}
