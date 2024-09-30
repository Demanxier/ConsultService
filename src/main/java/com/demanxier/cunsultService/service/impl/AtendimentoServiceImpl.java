package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.Atendimento;
import com.demanxier.cunsultService.entity.Consultor;
import com.demanxier.cunsultService.entity.Ticket;
import com.demanxier.cunsultService.entity.form.AtendimentoForm;
import com.demanxier.cunsultService.entity.form.AtendimentoUpdateForm;
import com.demanxier.cunsultService.exception.StatusAtendimento;
import com.demanxier.cunsultService.repository.AtendimentoRepository;
import com.demanxier.cunsultService.repository.ConsultorRepository;
import com.demanxier.cunsultService.repository.TicketRepository;
import com.demanxier.cunsultService.service.IAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtendimentoServiceImpl implements IAtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ConsultorRepository consultorRepository;

    @Override
    public Atendimento create(AtendimentoForm form) {
        Ticket ticket = ticketRepository.findById(form.getId_ticket())
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado."));

        Consultor consultor = consultorRepository.findById(form.getId_consultor())
                .orElseThrow(() -> new RuntimeException("Consultor não encontrado."));

        Atendimento atendimento = new Atendimento();
        atendimento.setTitulo(form.getTitulo());
        atendimento.setData(form.getData());
        atendimento.setHoraInicio(form.getHoraInicio());
        atendimento.setHoraFim(form.getHoraFim());
        atendimento.setStatus(StatusAtendimento.AGENDADO);

        atendimento.setTicket(ticket);
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
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Ticket> getAllTicket(LocalDate data) {
        return List.of();
    }

    @Override
    public List<Consultor> getAllConsultor(String nome) {
        return List.of();
    }
}
