package com.demanxier.cunsultService.controller;


import com.demanxier.cunsultService.entity.Atendimento;
import com.demanxier.cunsultService.entity.form.AtendimentoForm;
import com.demanxier.cunsultService.entity.form.AtendimentoUpdateForm;
import com.demanxier.cunsultService.service.impl.AtendimentoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoServiceImpl atendimentoService;

    @PostMapping
    public Atendimento create(@Valid @RequestBody AtendimentoForm form){
        return atendimentoService.create(form);
    }

    @GetMapping
    public List<Atendimento> getAll(){
        return atendimentoService.getAll();
    }

    @GetMapping("/{id}")
    public Atendimento get(@PathVariable Long id){
        return atendimentoService.get(id);
    }


    @PutMapping("/{id}")
    public Atendimento update(@PathVariable Long id, @Valid @RequestBody AtendimentoUpdateForm updateForm){
        return atendimentoService.update(id, updateForm);
    }
    @PutMapping("/{id}/em-atendimento")
    public Atendimento updateStatuEmAtendimento(@PathVariable Long id, @Valid @RequestBody AtendimentoUpdateForm updateForm){
        return atendimentoService.update(id, updateForm);
    }
    @PutMapping("/{id}/cancelar")
    public Atendimento updateStatuCancelado(@PathVariable Long id, @Valid @RequestBody AtendimentoUpdateForm updateForm){
        return atendimentoService.update(id, updateForm);
    }
    @PutMapping("/{id}/concluir")
    public Atendimento updateStatusConcluido(@PathVariable Long id, @Valid @RequestBody AtendimentoUpdateForm updateForm){
        return atendimentoService.update(id, updateForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        atendimentoService.delete(id);
    }
}
