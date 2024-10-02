package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.Atendimento;
import com.demanxier.cunsultService.entity.Cliente;
import com.demanxier.cunsultService.entity.Ticket;
import com.demanxier.cunsultService.entity.TicketExterno;
import com.demanxier.cunsultService.entity.form.TicketForm;
import com.demanxier.cunsultService.entity.form.TicketUpdateForm;
import com.demanxier.cunsultService.exception.StatusTicket;
import com.demanxier.cunsultService.repository.AtendimentoRepository;
import com.demanxier.cunsultService.repository.ClienteRepository;
import com.demanxier.cunsultService.repository.TicketExternoRepository;
import com.demanxier.cunsultService.repository.TicketRepository;
import com.demanxier.cunsultService.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private TicketExternoRepository ticketExternoRepository;

    @Override
    public Ticket create(TicketForm form) {
        Cliente cliente = clienteRepository.findById(form.getId_cliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        Atendimento atendimento = atendimentoRepository.findById(form.getId_atendimento())
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado."));

        TicketExterno ticketExterno = ticketExternoRepository.findById(form.getId_TicketExterno())
                .orElseThrow(() -> new RuntimeException("Ticket externo não encontrado"));

        Ticket ticket = new Ticket();
        ticket.setTitulo(form.getTitulo());
        ticket.setDescricao(form.getDescricao());
        ticket.setStatus(StatusTicket.NOVO);

        ticket.setCliente(cliente);
        ticket.setTicketExterno(ticketExterno);

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket get(Long id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket update(Long id, TicketUpdateForm updateForm) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Ticket não encontrado"));

        TicketExterno ticketExterno = ticketExternoRepository.findById(updateForm.getId_TicketExterno())
                .orElseThrow(() -> new RuntimeException("Ticket externo não encontrado"));

        ticket.setTitulo(updateForm.getDescricao());
        ticket.setStatus(updateForm.getStatus());
        ticket.setTicketExterno(ticketExterno);
        return ticketRepository.save(ticket);
    }

    @Override
    public void delete(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Ticket não encontrado"));

        ticketRepository.delete(ticket);
    }
}
