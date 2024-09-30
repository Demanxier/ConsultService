package com.demanxier.cunsultService.service;


import com.demanxier.cunsultService.entity.Consultor;
import com.demanxier.cunsultService.entity.form.ConsultorForm;

import java.util.List;

public interface IConsultorService {

    Consultor create(ConsultorForm form);

    Consultor get(Long id);

    List<Consultor> getAll();

    Consultor update(Long id, ConsultorForm form);

    void delete(Long id);
}
