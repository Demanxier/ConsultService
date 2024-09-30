package com.demanxier.cunsultService.entity;

import com.demanxier.cunsultService.exception.StatusTicket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private StatusTicket status;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "tb_ticket_consultor",
            joinColumns = @JoinColumn(name = "id_ticket"),
            inverseJoinColumns = @JoinColumn(name = "id_consultor"))
    private List<Consultor> consultores = new ArrayList<>();

    // @OneToMany(mappedBy = "id_atendimento") --> Errei ao relacionar errado.
    //O mappedBy é para indicar a relação um para muitos entre ticket e atendimento
    @OneToMany(mappedBy = "ticket")
    private List<Atendimento> atendimento = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_ticketExterno")
    private TicketExterno ticketExterno;
}
