package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.Empresa;
import com.demanxier.cunsultService.entity.form.EmpresaForm;
import com.demanxier.cunsultService.repository.EmpresaRepository;
import com.demanxier.cunsultService.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa create(EmpresaForm form) {
        Empresa empresa = new Empresa();
        empresa.setNome(form.getNome());
        empresa.setCnpj(form.getCnpj());

        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa get(Long id) {
        return null;
    }

    @Override
    public List<Empresa> getAll() {
        return List.of();
    }

    @Override
    public Empresa update(Long id, EmpresaForm form) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
