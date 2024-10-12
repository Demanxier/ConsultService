package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.entity.enums.StatusAtendimento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoUpdateForm {

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String titulo;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 5000, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String descricao;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private StatusAtendimento status;
}
