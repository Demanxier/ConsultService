package com.demanxier.cunsultService.controller;

import com.demanxier.cunsultService.entity.CardTarefa;
import com.demanxier.cunsultService.entity.form.CardTarefaForm;
import com.demanxier.cunsultService.entity.form.CardTarefaUpdateForm;
import com.demanxier.cunsultService.service.impl.CardTarefaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cards")
@CrossOrigin(origins = "http://localhost:3000")
public class CardTarefaController {

    @Autowired
    private CardTarefaServiceImpl cardService;

    @PostMapping("/tarefa/{tarefaId}")
    public ResponseEntity<CardTarefa> create(@PathVariable Long tarefaId, @RequestBody CardTarefaForm form){
        CardTarefa novoCard = cardService.create(tarefaId, form);

        return ResponseEntity.ok(novoCard);
    }

    @GetMapping("/tarefa/{tarefaId}")
    public ResponseEntity<List<CardTarefa>> listarCard(@PathVariable Long tarefaId){
        List<CardTarefa> cards = cardService.listarCardsPorTarefa(tarefaId);
        return ResponseEntity.ok(cards);
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<CardTarefa> editarCard(@PathVariable Long cardId, @RequestBody CardTarefaUpdateForm updateForm){
        CardTarefa cardAtualizado = cardService.update(cardId, updateForm);

        return ResponseEntity.ok(cardAtualizado);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deletarCard(@PathVariable Long cardId){
        cardService.delete(cardId);

        return ResponseEntity.noContent().build();
    }
}
