package com.demanxier.cunsultService.service;

import com.demanxier.cunsultService.entity.CardTarefa;
import com.demanxier.cunsultService.entity.form.CardTarefaForm;
import com.demanxier.cunsultService.entity.form.CardTarefaUpdateForm;

import java.util.List;

public interface ICardTarefaService {

    CardTarefa create(Long tarefaId, CardTarefaForm form);

    CardTarefa update(Long id, CardTarefaUpdateForm updateForm);

    void delete(Long id);

    List<CardTarefa> listarCardsPorTarefa(Long tarefaId);

}
