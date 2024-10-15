package com.demanxier.cunsultService.entity;

import com.demanxier.cunsultService.entity.enums.StatusTicket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_ticketExterno")
public class TicketExterno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String titulo;

    private  String descricao;

    private LocalDate dataAbertura = LocalDate.now();

    private LocalDate dataFechamento;

    private StatusTicket status;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_cliente", nullable = true)
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(mappedBy = "ticketExterno", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"ticketExterno"})
    private List<Atendimento> atendimentos = new ArrayList<>();
}
