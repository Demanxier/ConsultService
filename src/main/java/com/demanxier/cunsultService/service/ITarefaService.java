package com.demanxier.cunsultService.service;

import com.demanxier.cunsultService.entity.CardTarefa;
import com.demanxier.cunsultService.entity.Tarefa;
import com.demanxier.cunsultService.entity.enums.StatusTarefa;
import com.demanxier.cunsultService.entity.form.TarefaForm;
import com.demanxier.cunsultService.entity.form.TarefaUpdateForm;
import com.demanxier.cunsultService.entity.form.TarefaUpdateStatusForm;

import java.util.List;

public interface ITarefaService {

    Tarefa create(TarefaForm form);

    Tarefa get(Long id);

    List<Tarefa> getAll();

    Tarefa update(Long id, TarefaUpdateForm updateForm);

    void delete(Long id);

    Tarefa statusAFazer(Long id, TarefaUpdateForm updateForm);

    Tarefa statusFazendo(Long id, TarefaUpdateForm updateForm);

    Tarefa statusPausado(Long id, TarefaUpdateForm updateForm);

    Tarefa statusConcluido(Long id, TarefaUpdateForm updateForm);

    Tarefa atualizarStatus(Long id, TarefaUpdateStatusForm statusForm);


}
