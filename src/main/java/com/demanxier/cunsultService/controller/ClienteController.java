package com.demanxier.cunsultService.controller;


import com.demanxier.cunsultService.entity.Cliente;
import com.demanxier.cunsultService.entity.form.ClienteForm;
import com.demanxier.cunsultService.entity.form.ClienteUpdateForm;
import com.demanxier.cunsultService.service.impl.ClienteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping
    public Cliente create(@Valid @RequestBody ClienteForm form){
        return clienteService.create(form);
    }

    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public Cliente get(@PathVariable Long id){
        return clienteService.get(id);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @Valid @RequestBody ClienteUpdateForm updateForm){
        return clienteService.update(id, updateForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
}
