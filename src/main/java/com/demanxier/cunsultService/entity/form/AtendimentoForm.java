package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.exception.StatusAtendimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoForm {

    private LocalDate data;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private String descricao;

    private StatusAtendimento status;
}
