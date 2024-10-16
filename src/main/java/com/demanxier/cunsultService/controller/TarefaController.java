package com.demanxier.cunsultService.controller;

import com.demanxier.cunsultService.entity.Tarefa;
import com.demanxier.cunsultService.entity.form.TarefaForm;
import com.demanxier.cunsultService.entity.form.TarefaUpdateForm;
import com.demanxier.cunsultService.entity.form.TarefaUpdateStatusForm;
import com.demanxier.cunsultService.service.impl.TarefaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tarefa")
@CrossOrigin(origins = "http://localhost:3000")
public class TarefaController {

    @Autowired
    private TarefaServiceImpl tarefaService;

    @PostMapping
    public Tarefa create(@Valid @RequestBody TarefaForm form){
        return tarefaService.create(form);
    }

    @GetMapping
    public List<Tarefa> getAll(){
        return tarefaService.getAll();
    }

    @GetMapping("/{id}")
    public Tarefa get(@PathVariable Long id){
        return tarefaService.get(id);
    }

    @PutMapping("/{id}")
    public Tarefa update(@PathVariable Long id, @Valid @RequestBody TarefaUpdateForm updateForm){
        return tarefaService.update(id, updateForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        tarefaService.delete(id);
    }

    @PutMapping("/{id}/status")
    public Tarefa atualizarStatus(@PathVariable Long id, @Valid @RequestBody TarefaUpdateStatusForm statusForm){
        return tarefaService.atualizarStatus(id, statusForm);
    }
}
