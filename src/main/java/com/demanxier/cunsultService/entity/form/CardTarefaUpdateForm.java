package com.demanxier.cunsultService.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardTarefaUpdateForm {

    private String conteudo;

    private LocalDateTime atualzadoEm;
}
