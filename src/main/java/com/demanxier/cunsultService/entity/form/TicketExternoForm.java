package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.entity.Atendimento;
import com.demanxier.cunsultService.entity.Cliente;
import com.demanxier.cunsultService.entity.enums.StatusTicket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketExternoForm {

    private  String titulo;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 5, max = 5000, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private  String descricao;

    private LocalDate dataAbertura = LocalDate.now();

    private LocalDate dataFechamento;

    private StatusTicket status;

    private Long clienteId;
}
