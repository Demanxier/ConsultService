package com.demanxier.cunsultService.entity;

import com.demanxier.cunsultService.entity.enums.StatusAtendimento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String titulo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFim;
    @NotNull
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusAtendimento status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tarefa")
    @JsonIgnoreProperties({"atendimento"}) // Ignora a lista ded atendimentos no ticket para evitar coclos
    private Tarefa tarefa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_consultor")
    @JsonIgnoreProperties({"atendimentos"})
    private Consultor consultor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ticket_externo")
    @JsonIgnoreProperties("atendimentos")
    private TicketExterno ticketExterno;
}
