package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.exception.StatusAtendimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoUpdateForm {

    private String titulo;

    private String descricao;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private StatusAtendimento status;
}
