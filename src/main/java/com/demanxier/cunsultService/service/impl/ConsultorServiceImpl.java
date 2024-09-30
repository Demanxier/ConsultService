package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.Consultor;
import com.demanxier.cunsultService.entity.form.ConsultorForm;
import com.demanxier.cunsultService.repository.ConsultorRepository;
import com.demanxier.cunsultService.service.IConsultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultorServiceImpl implements IConsultorService {

    @Autowired
    private ConsultorRepository consultorRepository;



    @Override
    public Consultor create(ConsultorForm form) {
        Consultor consultor = new Consultor();
        consultor.setNome(form.getNome());
        consultor.setEmail(form.getEmail());
        consultor.setSenha(form.getSenha());
        consultor.setExterno(form.isExterno());

        if(form.isExterno()){
            consultor.setCustoHora(form.getCustoHora());
        }else {
            consultor.setCustoHora(0.0);
        }
        return consultorRepository.save(consultor);
    }

    @Override
    public Consultor get(Long id) {
        return consultorRepository.findById(id).get();
    }

    @Override
    public List<Consultor> getAll() {
        return consultorRepository.findAll();
    }

    @Override
    public Consultor update(Long id, ConsultorForm form) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
