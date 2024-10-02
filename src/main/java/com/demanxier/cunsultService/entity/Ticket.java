package com.demanxier.cunsultService.entity;

import com.demanxier.cunsultService.entity.enums.StatusTicket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference //Impede a serialização recursiva entre Cliente e Ticket
    private Cliente cliente;

    // @OneToMany(mappedBy = "id_atendimento") --> Errei ao relacionar errado.
    //O mappedBy é para indicar a relação um para muitos entre ticket e atendimento
    @OneToMany(mappedBy = "ticket")
    @JsonManagedReference //Define que a serialização deve começar a partir deste ponto
    private List<Atendimento> atendimento = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_ticketExterno")
    private TicketExterno ticketExterno;
}
