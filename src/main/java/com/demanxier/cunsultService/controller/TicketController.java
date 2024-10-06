package com.demanxier.cunsultService.controller;

import com.demanxier.cunsultService.entity.Ticket;
import com.demanxier.cunsultService.entity.form.TicketForm;
import com.demanxier.cunsultService.entity.form.TicketUpdateForm;
import com.demanxier.cunsultService.service.impl.TicketServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ticket")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @PostMapping
    public Ticket create(@Valid @RequestBody TicketForm form){
        return ticketService.create(form);
    }

    @GetMapping
    public List<Ticket> getAll(){
        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public Ticket get(@PathVariable Long id){
        return ticketService.get(id);
    }

    @PutMapping("/{id}")
    public Ticket update(@PathVariable Long id, @Valid @RequestBody TicketUpdateForm updateForm){
        return ticketService.update(id, updateForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        ticketService.delete(id);
    }
}
