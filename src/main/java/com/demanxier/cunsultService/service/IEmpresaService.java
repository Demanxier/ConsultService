package com.demanxier.cunsultService.service;

import com.demanxier.cunsultService.entity.Empresa;
import com.demanxier.cunsultService.entity.form.EmpresaForm;

import java.util.List;

public interface IEmpresaService {

    Empresa create(EmpresaForm form);

    Empresa get(Long id);

    List<Empresa> getAll();

    Empresa update(Long id, EmpresaForm form);

    void delete(Long id);
}
