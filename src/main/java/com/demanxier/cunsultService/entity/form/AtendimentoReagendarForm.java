package com.demanxier.cunsultService.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoReagendarForm {
    private LocalDate novaData;
    private LocalTime novaHoraInicio;
    private LocalTime novaHoraFim;
}
