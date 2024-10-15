package com.demanxier.cunsultService.service;

import com.demanxier.cunsultService.entity.TicketExterno;
import com.demanxier.cunsultService.entity.form.TicketExternoForm;


import java.util.List;

public interface ITicketExternoService {

    TicketExterno create(TicketExternoForm form);

    TicketExterno get(Long id);

    List<TicketExterno> getAll();

    TicketExterno update(Long id, TicketExternoForm form);

    void delete(Long id);

    List<TicketExterno> listarTicketsSemAtendimentos();
    List<TicketExterno> listarTicketsComAtendimentos();
}
