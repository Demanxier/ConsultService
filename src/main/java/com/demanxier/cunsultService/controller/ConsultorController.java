package com.demanxier.cunsultService.controller;


import com.demanxier.cunsultService.entity.Consultor;
import com.demanxier.cunsultService.entity.form.ConsultorForm;
import com.demanxier.cunsultService.entity.form.ConsultorUpdateForm;
import com.demanxier.cunsultService.service.impl.ConsultorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/consultor")
public class ConsultorController {

    @Autowired
    private ConsultorServiceImpl consultorService;

    @PostMapping
    public Consultor create(@Valid @RequestBody ConsultorForm form){
        return consultorService.create(form);
    }

    @GetMapping
    public List<Consultor> getAll(){
        return consultorService.getAll();
    }

    @GetMapping("/{id}")
    public Consultor get(@PathVariable Long id){
        return consultorService.get(id);
    }

    @PutMapping("/{id}")
    public Consultor update(@PathVariable Long id, @Valid @RequestBody ConsultorUpdateForm updateForm){
        return consultorService.update(id, updateForm);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        consultorService.delete(id);
    }

}
