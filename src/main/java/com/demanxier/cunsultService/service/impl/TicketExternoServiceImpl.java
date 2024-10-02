package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.TicketExterno;
import com.demanxier.cunsultService.entity.form.TicketExternoForm;
import com.demanxier.cunsultService.repository.TicketExternoRepository;
import com.demanxier.cunsultService.service.ITicketExternoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketExternoServiceImpl implements ITicketExternoService {

    @Autowired
    private TicketExternoRepository ticketExternoRepository;


    @Override
    public TicketExterno create(TicketExternoForm form) {

        TicketExterno ticketExterno = new TicketExterno();
        ticketExterno.setTitulo(form.getTitulo());
        ticketExterno.setDescricao(form.getDescricao());
        return ticketExternoRepository.save(ticketExterno);
    }


    @Override
    public TicketExterno get(Long id) {
        return ticketExternoRepository.findById(id).get();
    }

    @Override
    public List<TicketExterno> getAll() {
        return ticketExternoRepository.findAll();
    }

    @Override
    public TicketExterno update(Long id, TicketExternoForm form) {
        TicketExterno ticketExterno = ticketExternoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Ticket Externo não encontrado."));

        ticketExterno.setTitulo(form.getTitulo());
        ticketExterno.setDescricao(form.getDescricao());
        return ticketExternoRepository.save(ticketExterno);
    }

    @Override
    public void delete(Long id) {
        TicketExterno ticketExterno = ticketExternoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Ticket Externo não encontrado."));

        ticketExternoRepository.delete(ticketExterno);

    }
}
