package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.entity.enums.StatusTarefa;
import com.demanxier.cunsultService.entity.enums.StatusTicket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaForm {

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 30, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String titulo;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 5000, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String descricao;

    private StatusTarefa status;

    private LocalDate vencimento;

    private Long id_cliente;

    private Long id_atendimento;


}
