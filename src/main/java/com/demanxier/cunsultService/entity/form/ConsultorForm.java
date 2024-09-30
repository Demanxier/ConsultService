package com.demanxier.cunsultService.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultorForm {

    private String nome;

    private String email;

    private String senha;

    private boolean externo;

    private Double custoHora;

    private Long id_atendimento;
}
