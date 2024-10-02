package com.demanxier.cunsultService.service;


import com.demanxier.cunsultService.entity.Consultor;
import com.demanxier.cunsultService.entity.form.ConsultorForm;
import com.demanxier.cunsultService.entity.form.ConsultorUpdateForm;

import java.util.List;

public interface IConsultorService {

    Consultor create(ConsultorForm form);

    Consultor get(Long id);

    List<Consultor> getAll();

    Consultor update(Long id, ConsultorUpdateForm updateForm);

    void delete(Long id);
}
