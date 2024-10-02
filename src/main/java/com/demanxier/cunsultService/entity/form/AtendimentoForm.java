package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.entity.enums.StatusAtendimento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoForm {

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 30, message = "'${validatedValue}' precisa estar entre ${min} e ${max} caracteres.")
    private String titulo;

    private LocalDate data;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private String descricao;

    private StatusAtendimento status;

    private Long id_consultor;

    private Long id_ticket;

}
