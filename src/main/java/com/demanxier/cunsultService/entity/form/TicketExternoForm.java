package com.demanxier.cunsultService.entity.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketExternoForm {

    private  String titulo;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 5000, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private  String descricao;
}
