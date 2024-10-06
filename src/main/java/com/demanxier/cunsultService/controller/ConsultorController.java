package com.demanxier.cunsultService.controller;


import com.demanxier.cunsultService.entity.Consultor;
import com.demanxier.cunsultService.entity.form.ConsultorForm;
import com.demanxier.cunsultService.entity.form.ConsultorLoginForm;
import com.demanxier.cunsultService.entity.form.ConsultorUpdateForm;
import com.demanxier.cunsultService.response.ConsultorResponse;
import com.demanxier.cunsultService.service.impl.ConsultorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;

@RestController
@RequestMapping("/v1/consultor")
@CrossOrigin(origins = "http://localhost:3000")
public class ConsultorController {

    @Autowired
    private ConsultorServiceImpl consultorService;

    @PostMapping
    public Consultor create(@Valid @RequestBody ConsultorForm form){
        return consultorService.create(form);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ConsultorLoginForm loginForm){
        try{
            Consultor consultor = consultorService.login(loginForm);
            ConsultorResponse response = new ConsultorResponse(consultor);
            return ResponseEntity.ok(response);
        }catch (LoginException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
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
