package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.entity.enums.StatusTarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaUpdateForm {

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 5000, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String descricao;

    private StatusTarefa status;

    private LocalDate vencimento;


}
