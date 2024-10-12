package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.Atendimento;
import com.demanxier.cunsultService.entity.Consultor;
import com.demanxier.cunsultService.entity.Tarefa;
import com.demanxier.cunsultService.entity.form.AtendimentoForm;
import com.demanxier.cunsultService.entity.form.AtendimentoReagendarForm;
import com.demanxier.cunsultService.entity.form.AtendimentoUpdateForm;
import com.demanxier.cunsultService.entity.enums.StatusAtendimento;
import com.demanxier.cunsultService.repository.AtendimentoRepository;
import com.demanxier.cunsultService.repository.ConsultorRepository;
import com.demanxier.cunsultService.repository.TarefaRepository;
import com.demanxier.cunsultService.service.IAtendimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtendimentoServiceImpl implements IAtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ConsultorRepository consultorRepository;

    @Override
    public Atendimento create(AtendimentoForm form) {
        Tarefa tarefa = tarefaRepository.findById(form.getId_tarefa())
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado."));

        Consultor consultor = consultorRepository.findById(form.getId_consultor())
                .orElseThrow(() -> new RuntimeException("Consultor não encontrado."));

        Atendimento atendimento = new Atendimento();
        atendimento.setTitulo(form.getTitulo());
        atendimento.setData(form.getData());
        atendimento.setDescricao(form.getDescricao());
        atendimento.setHoraInicio(form.getHoraInicio());
        atendimento.setHoraFim(form.getHoraFim());
        atendimento.setStatus(StatusAtendimento.AGENDADO);

        atendimento.setTarefa(tarefa);
        atendimento.setConsultor(consultor);

        return atendimentoRepository.save(atendimento);
    }

    @Override
    public Atendimento get(Long id) {
        return atendimentoRepository.findById(id).get();
    }

    @Override
    public List<Atendimento> getAll() {
        return atendimentoRepository.findAll();
    }

    @Override
    public Atendimento update(Long id, AtendimentoUpdateForm formUpdate) {
        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Atendimento não encontrado."));

        atendimento.setTitulo(formUpdate.getTitulo());
        atendimento.setDescricao(formUpdate.getDescricao());
        return atendimentoRepository.save(atendimento);
    }

    @Override
    public void delete(Long id) {
        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Atendimento não encontrado."));

        atendimentoRepository.delete(atendimento);
    }

    @Override
    public List<Tarefa> getAllTicket(LocalDate data) {
        return List.of();
    }

    @Override
    public List<Consultor> getAllConsultor(String nome) {
        return List.of();
    }

    @Override
    public Atendimento updateStatuCancelado(Long id, AtendimentoUpdateForm updateForm) {
        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Atendimento não encontrado."));

        atendimento.setStatus(StatusAtendimento.CANCELADO);

        if(updateForm != null){
            if (updateForm.getDescricao() != null){
                atendimento.setDescricao(updateForm.getDescricao());
            }
            if (updateForm.getHoraInicio() != null){
                atendimento.setHoraInicio(updateForm.getHoraInicio());
            }
            if (updateForm.getHoraFim() != null){
                atendimento.setHoraFim(updateForm.getHoraFim());
            }
        }

        return atendimentoRepository.save(atendimento);
    }

    @Override
    public Atendimento updateStatusConcluido(Long id, AtendimentoUpdateForm updateForm) {
        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Atendimento não encontrado."));

        atendimento.setStatus(StatusAtendimento.CONCLUIDO);

        if(updateForm != null){
            if (updateForm.getDescricao() != null){
                atendimento.setDescricao(updateForm.getDescricao());
            }
            if (updateForm.getHoraInicio() != null){
                atendimento.setHoraInicio(updateForm.getHoraInicio());
            }
            if (updateForm.getHoraFim() != null){
                atendimento.setHoraFim(updateForm.getHoraFim());
            }
        }

        return atendimentoRepository.save(atendimento);
    }

    @Override
    public List<Atendimento> search(String titulo, LocalDate startDate, LocalDate endDate) {
        if (titulo != null && !titulo.isEmpty() && startDate != null && endDate != null){
            return atendimentoRepository.findByTituloContainingIgnoreCaseAndDataBetween(titulo, startDate, endDate);
        } else if (titulo != null && !titulo.isEmpty()) {
            return atendimentoRepository.findByTituloContainingIgnoreCase(titulo);
        } else if (startDate != null && endDate != null) {
            return atendimentoRepository.findByDataBetween(startDate, endDate);
        }else {
            return atendimentoRepository.findAll();
        }
    }

    @Override
    public List<Atendimento> searchAtender(String titulo, LocalDate startDate, LocalDate endDate) {
        List<Atendimento>  atendimentos;

        if (titulo != null && !titulo.isEmpty() && startDate != null && endDate != null){
            atendimentos = atendimentoRepository.findByTituloContainingIgnoreCaseAndDataBetween(titulo, startDate, endDate);
        } else if (titulo != null && !titulo.isEmpty()) {
            atendimentos = atendimentoRepository.findByTituloContainingIgnoreCase(titulo);
        } else if (startDate != null && endDate != null) {
            atendimentos = atendimentoRepository.findByDataBetween(startDate, endDate);
        }else {
            atendimentos = atendimentoRepository.findAll();
        }

        return atendimentos.stream()
                .filter(atendimento -> !atendimento.getStatus().equals(StatusAtendimento.CONCLUIDO))
                .filter(atendimento -> !atendimento.getStatus().equals(StatusAtendimento.CANCELADO))
                .collect(Collectors.toList());
    }

    @Override
    public Atendimento reagendar(Long id, AtendimentoReagendarForm reagendarForm) {
        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Antendimento não encontrado."));

        atendimento.setData(reagendarForm.getNovaData());
        atendimento.setHoraInicio(reagendarForm.getNovaHoraInicio());
        atendimento.setHoraFim(reagendarForm.getNovaHoraFim());
        atendimento.setStatus(StatusAtendimento.AGENDADO);

        return atendimentoRepository.save(atendimento);
    }

    @Override
    public Atendimento updateStatusEmAtendimento(Long id, AtendimentoUpdateForm updateForm) {
        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Atendimento não encontrado."));

        if (!atendimento.getStatus().equals(StatusAtendimento.EM_ATENDIMENTO)){
            atendimento.setStatus(StatusAtendimento.EM_ATENDIMENTO);
        }
        // Opcional: Atualizar hora de início se fornecida
        if (updateForm != null && updateForm.getHoraInicio() != null) {
            atendimento.setHoraInicio(updateForm.getHoraInicio());
        }
        Atendimento atendSalvo = atendimentoRepository.save(atendimento);
        return atendSalvo;
    }


    /* Usado para investigar porque não estava funcionando o endpoint
    // Dentro da classe AtendimentoServiceImpl
private static final Logger logger = LoggerFactory.getLogger(AtendimentoServiceImpl.class);

@Override
public Atendimento updateStatusEmAtendimento(Long id, AtendimentoUpdateForm formUpdate) {
    logger.info("Iniciando atualização do status para EM_ATENDIMENTO do Atendimento ID: {}", id);

    Atendimento atendimento = atendimentoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Atendimento não encontrado."));

    logger.info("Status atual do atendimento: {}", atendimento.getStatus());

    if (!atendimento.getStatus().equals(StatusAtendimento.EM_ATENDIMENTO)) {
        atendimento.setStatus(StatusAtendimento.EM_ATENDIMENTO);
        logger.info("Status atualizado para EM_ATENDIMENTO.");
    } else {
        logger.info("O atendimento já está em EM_ATENDIMENTO.");
    }

    // Opcional: Atualizar hora de início se fornecida
    if (formUpdate != null && formUpdate.getHoraInicio() != null) {
        atendimento.setHoraInicio(formUpdate.getHoraInicio());
        logger.info("Hora de início atualizada para: {}", formUpdate.getHoraInicio());
    }

    Atendimento atendSalvo = atendimentoRepository.save(atendimento);
    logger.info("Atendimento salvo com ID: {} e Status: {}", atendSalvo.getId(), atendSalvo.getStatus());

    return atendSalvo;
}
     */
}
