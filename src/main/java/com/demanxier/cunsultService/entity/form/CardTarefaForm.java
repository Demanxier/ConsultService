package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.entity.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardTarefaForm {

    private String conteudo;

    private LocalDateTime criadoEm;

    private Long id_tarefa;

    private Tarefa tarefa;

}
