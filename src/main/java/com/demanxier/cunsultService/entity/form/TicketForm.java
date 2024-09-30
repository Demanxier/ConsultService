package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.entity.Cliente;
import com.demanxier.cunsultService.exception.StatusTicket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketForm {

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 30, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String titulo;

    private String descricao;

    private StatusTicket status;

    private Long id_cliente;

    private Long id_atendimento;

    private Long id_TicketExterno;

}
