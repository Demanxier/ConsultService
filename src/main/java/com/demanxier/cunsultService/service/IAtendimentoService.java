package com.demanxier.cunsultService.service;

import com.demanxier.cunsultService.entity.Atendimento;
import com.demanxier.cunsultService.entity.Consultor;
import com.demanxier.cunsultService.entity.Tarefa;
import com.demanxier.cunsultService.entity.form.AtendimentoForm;
import com.demanxier.cunsultService.entity.form.AtendimentoReagendarForm;
import com.demanxier.cunsultService.entity.form.AtendimentoUpdateForm;

import java.time.LocalDate;
import java.util.List;

public interface IAtendimentoService {

    /**
     * Cria um Atendimento e salva no banco de dados.
     * @param form - formulário referente aos dados para criação de um Atendimento no banco de dados.
     * @return - Atendimento recém-criado.
     */
    Atendimento create(AtendimentoForm form);

    Atendimento get(Long id);

    List<Atendimento> getAll();

    Atendimento update(Long id, AtendimentoUpdateForm formUpdate);

    void delete(Long id);

    List<Tarefa> getAllTicket(LocalDate data);

    List<Consultor> getAllConsultor (String nome);

    Atendimento updateStatusEmAtendimento(Long id, AtendimentoUpdateForm updateForm);

    Atendimento updateStatuCancelado(Long id, AtendimentoUpdateForm updateForm);

    Atendimento updateStatusConcluido(Long id, AtendimentoUpdateForm updateForm);

    List<Atendimento> search(String titulo, LocalDate startDate, LocalDate endDate);

    Atendimento reagendar(Long id, AtendimentoReagendarForm reagendarForm);

    List<Atendimento> searchAtender(String titulo, LocalDate startDate, LocalDate endDate);


}
