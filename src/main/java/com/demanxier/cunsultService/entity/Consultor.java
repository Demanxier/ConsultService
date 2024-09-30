package com.demanxier.cunsultService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "tb_consultor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    private boolean externo;

    private Double custoHora;

    @ManyToMany(mappedBy = "consultor")
    @JsonIgnore
    private List<Ticket> tickets = new ArrayList<>();
}
