package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.CardTarefa;
import com.demanxier.cunsultService.entity.Tarefa;
import com.demanxier.cunsultService.entity.form.CardTarefaForm;
import com.demanxier.cunsultService.entity.form.CardTarefaUpdateForm;
import com.demanxier.cunsultService.repository.CardTarefaRepository;
import com.demanxier.cunsultService.repository.TarefaRepository;
import com.demanxier.cunsultService.service.ICardTarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardTarefaServiceImpl implements ICardTarefaService {

    @Autowired
    private CardTarefaRepository cardTarefaRepository;

    @Autowired
    private TarefaRepository tarefaRepository;


    @Override
    public CardTarefa create(Long tarefaId, CardTarefaForm form) {
        Tarefa tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada."));

        CardTarefa cardTarefa = new CardTarefa();

        cardTarefa.setConteudo(form.getConteudo());
        cardTarefa.setCriadoEm(LocalDateTime.now());

        cardTarefa.setTarefa(tarefa);

        return cardTarefaRepository.save(cardTarefa);
    }

    @Override
    public CardTarefa update(Long id, CardTarefaUpdateForm updateForm) {
        CardTarefa cardTarefa = cardTarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card não encontrado."));

        cardTarefa.setConteudo(updateForm.getConteudo());
        cardTarefa.setAtualzadoEm(LocalDateTime.now());

        return cardTarefaRepository.save(cardTarefa);
    }

    @Override
    public void delete(Long id) {
        CardTarefa cardTarefa = cardTarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Carda não encontrado."));

        cardTarefaRepository.delete(cardTarefa);
    }

    @Override
    public List<CardTarefa> listarCardsPorTarefa(Long tarefaId) {
        Tarefa tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada."));

        return tarefa.getCards();
    }
    /*
    Apenas vou listar card por tarefa, pois os mesmo sempre devem estar listados
    juntos com suas tarefas.
     */
}
