package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.Cliente;
import com.demanxier.cunsultService.entity.Tarefa;
import com.demanxier.cunsultService.entity.enums.StatusTarefa;
import com.demanxier.cunsultService.entity.form.TarefaForm;
import com.demanxier.cunsultService.entity.form.TarefaUpdateForm;
import com.demanxier.cunsultService.repository.AtendimentoRepository;
import com.demanxier.cunsultService.repository.ClienteRepository;
import com.demanxier.cunsultService.repository.TarefaRepository;
import com.demanxier.cunsultService.service.ITarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaServiceImpl implements ITarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AtendimentoRepository atendimentoRepository;


    @Override
    public Tarefa create(TarefaForm form) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(form.getTitulo());
        tarefa.setDescricao(form.getDescricao());
        tarefa.setStatus(StatusTarefa.A_FAZER);
        tarefa.setVencimento(form.getVencimento());

        if(form.getId_cliente() != null){
            Cliente cliente = clienteRepository.findById(form.getId_cliente())
                    .orElseThrow(()-> new RuntimeException("Cliente não encontrado."));
            tarefa.setCliente(cliente);
        }else {
            tarefa.setCliente(null);
        }

        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa get(Long id) {
        return tarefaRepository.findById(id).get();
    }

    @Override
    public List<Tarefa> getAll() {
        return tarefaRepository.findAll();
    }

    @Override
    public Tarefa update(Long id, TarefaUpdateForm updateForm) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada."));

        tarefa.setDescricao(updateForm.getDescricao());
        tarefa.setStatus(updateForm.getStatus());
        tarefa.setVencimento(updateForm.getVencimento());
    return tarefaRepository.save(tarefa);
    }

    @Override
    public void delete(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada."));

        tarefaRepository.delete(tarefa);
    }

    @Override
    public Tarefa statusAFazer(Long id, TarefaUpdateForm updateForm) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada."));

        tarefa.setStatus(StatusTarefa.A_FAZER);

        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa statusFazendo(Long id, TarefaUpdateForm updateForm) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada."));

        tarefa.setStatus(StatusTarefa.FAZENDO);

        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa statusPausado(Long id, TarefaUpdateForm updateForm) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada."));

        tarefa.setStatus(StatusTarefa.PAUSADO);

        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa statusConcluido(Long id, TarefaUpdateForm updateForm) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada."));

        tarefa.setStatus(StatusTarefa.CONCLUIDO);

        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa atualizarStatus(Long id, StatusTarefa novoStatus) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada."));
        tarefa.setStatus(novoStatus);

        if (novoStatus == StatusTarefa.CONCLUIDO){
            tarefa.setDataConcluido(LocalDateTime.now());
        }else {
            tarefa.setDataConcluido(null);
        }
        return tarefaRepository.save(tarefa);
    }

}
