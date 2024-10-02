package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.exception.StatusAtendimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoUpdateForm {

    private String titulo;

    private String descricao;

    private StatusAtendimento status;
}
