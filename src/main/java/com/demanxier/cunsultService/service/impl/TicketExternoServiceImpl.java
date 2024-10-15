package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.Cliente;
import com.demanxier.cunsultService.entity.TicketExterno;
import com.demanxier.cunsultService.entity.enums.StatusTicket;
import com.demanxier.cunsultService.entity.form.TicketExternoForm;
import com.demanxier.cunsultService.repository.ClienteRepository;
import com.demanxier.cunsultService.repository.TicketExternoRepository;
import com.demanxier.cunsultService.service.ITicketExternoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketExternoServiceImpl implements ITicketExternoService {

    @Autowired
    private TicketExternoRepository ticketExternoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public TicketExterno create(TicketExternoForm form) {

        TicketExterno ticketExterno = new TicketExterno();
        ticketExterno.setTitulo(form.getTitulo());
        ticketExterno.setDescricao(form.getDescricao());
        ticketExterno.setStatus(form.getStatus() != null ? form.getStatus() : StatusTicket.NOVO);

        if(form.getClienteId() != null){
            Cliente cliente = clienteRepository.findById(form.getClienteId())
                    .orElseThrow(()-> new RuntimeException("Cliente não encontrado."));
            ticketExterno.setCliente(cliente);
        }else {
            ticketExterno.setCliente(null);
        }
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
        ticketExterno.setDataFechamento(form.getDataFechamento());
        ticketExterno.setStatus(form.getStatus());

        if(form.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(form.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
            ticketExterno.setCliente(cliente);
        } else {
            ticketExterno.setCliente(null);
        }

        return ticketExternoRepository.save(ticketExterno);
    }

    @Override
    public void delete(Long id) {
        TicketExterno ticketExterno = ticketExternoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Ticket Externo não encontrado."));

        ticketExternoRepository.delete(ticketExterno);

    }

    @Override
    public List<TicketExterno> listarTicketsSemAtendimentos() {
        return ticketExternoRepository.findAllTicketsSemAtendimentos();
    }

    @Override
    public List<TicketExterno> listarTicketsComAtendimentos() {
        return ticketExternoRepository.findAllTicketsComAtendimentos();
    }
}
