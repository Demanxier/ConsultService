package com.demanxier.cunsultService.response;

import com.demanxier.cunsultService.entity.Consultor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultorResponse {

    private Long id;
    private String nome;
    private String email;
    private boolean externo;
    private Double custoHora;

    public ConsultorResponse(Consultor consultor){
        this.id = consultor.getId();
        this.nome = consultor.getNome();
        this.email = consultor.getEmail();
        this.externo = consultor.isExterno();
        this.custoHora = consultor.getCustoHora();
    }
}
