package com.demanxier.cunsultService.entity;

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
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    @JsonBackReference //Impede a serialização recursiva entre Cliente e Empresa
    private Empresa empresa;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference //Define que a serialização deve começar a partir deste ponto
    private List<Tarefa> tarefas = new ArrayList<>();
}
