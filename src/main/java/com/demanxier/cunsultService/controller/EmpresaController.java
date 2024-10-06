package com.demanxier.cunsultService.controller;

import com.demanxier.cunsultService.entity.Empresa;
import com.demanxier.cunsultService.entity.form.EmpresaForm;
import com.demanxier.cunsultService.service.impl.EmpresaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/empresa")
@CrossOrigin(origins = "http://localhost:3000")
public class EmpresaController {

    @Autowired
    private EmpresaServiceImpl empresaService;

    @PostMapping
    public Empresa create(@Valid @RequestBody EmpresaForm form){
        return empresaService.create(form);
    }

    @GetMapping
    public List<Empresa> getAll(){
        return empresaService.getAll();
    }

    @GetMapping("/{id}")
    public Empresa get(@PathVariable Long id){
        return empresaService.get(id);
    }

    @PutMapping("/{id}")
    public Empresa update(@PathVariable Long id, @Valid @RequestBody EmpresaForm form){
        return empresaService.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        empresaService.delete(id);
    }
}
