package com.demanxier.cunsultService.controller;

import com.demanxier.cunsultService.entity.TicketExterno;
import com.demanxier.cunsultService.entity.form.TicketExternoForm;
import com.demanxier.cunsultService.service.impl.TicketExternoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ticketexterno")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketExternoController {

    @Autowired
    private TicketExternoServiceImpl ticketExternoService;

    @PostMapping
    public TicketExterno create(@Valid @RequestBody TicketExternoForm form){
        return ticketExternoService.create(form);
    }

    @GetMapping
    public List<TicketExterno> getAll(){
        return ticketExternoService.getAll();
    }

    @GetMapping("/{id}")
    public TicketExterno get(@PathVariable Long id){
        return ticketExternoService.get(id);
    }

    @PutMapping("/{id}")
    public TicketExterno update(@PathVariable Long id, @Valid @RequestBody TicketExternoForm form){
        return ticketExternoService.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        ticketExternoService.delete(id);
    }
}
