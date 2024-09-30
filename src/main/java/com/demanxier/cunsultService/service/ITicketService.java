package com.demanxier.cunsultService.service;

import com.demanxier.cunsultService.entity.Ticket;
import com.demanxier.cunsultService.entity.form.TicketForm;
import com.demanxier.cunsultService.entity.form.TicketUpdateForm;

import java.util.List;

public interface ITicketService {

    Ticket create(TicketForm form);

    Ticket get(Long id);

    List<Ticket> getAll();

    Ticket update(Long id, TicketUpdateForm updateForm);

    void delete(Long id);
}
