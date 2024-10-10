package com.demanxier.cunsultService.controller;


import com.demanxier.cunsultService.entity.Atendimento;
import com.demanxier.cunsultService.entity.form.AtendimentoForm;
import com.demanxier.cunsultService.entity.form.AtendimentoReagendarForm;
import com.demanxier.cunsultService.entity.form.AtendimentoUpdateForm;
import com.demanxier.cunsultService.service.impl.AtendimentoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/atendimento")
@CrossOrigin(origins = "http://localhost:3000")
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
    @PostMapping("/{id}/iniciar")
    public ResponseEntity<Atendimento> iniciarAtendimento(@PathVariable Long id) {
        try{
            Atendimento atendimento = atendimentoService.updateStatusEmAtendimento(id, null);
            return ResponseEntity.ok(atendimento);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}/reagendar")
    public ResponseEntity<Atendimento> reagendarAtendimento(@PathVariable Long id, @RequestBody AtendimentoReagendarForm reagendarForm){
        try {
            Atendimento atendimento = atendimentoService.reagendar(id, reagendarForm);
            return ResponseEntity.ok(atendimento);
        } catch (RuntimeException  e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Atendimento> cancelarAtendimento(@PathVariable Long id, @RequestBody AtendimentoUpdateForm updateForm){
        try {
            Atendimento atendimento = atendimentoService.updateStatuCancelado(id, updateForm);
            return ResponseEntity.ok(atendimento);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}/concluir")
    public ResponseEntity<Atendimento> concluirAtendimento(@PathVariable Long id, @RequestBody AtendimentoUpdateForm updateForm){
        try {
            Atendimento atendimento =  atendimentoService.updateStatusConcluido(id, updateForm);
            return ResponseEntity.ok(atendimento);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        atendimentoService.delete(id);
    }

    @GetMapping("/buscar")
    public List<Atendimento> searchAtendimentos(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
            ) {
        return atendimentoService.search(titulo, startDate, endDate);
    }

    @GetMapping("/atender")
    public List<Atendimento> searchAtender(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return atendimentoService.searchAtender(titulo, startDate, endDate);
    }

}
