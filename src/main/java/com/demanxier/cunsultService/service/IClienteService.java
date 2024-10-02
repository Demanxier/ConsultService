package com.demanxier.cunsultService.service;

import com.demanxier.cunsultService.entity.Cliente;
import com.demanxier.cunsultService.entity.form.ClienteForm;
import com.demanxier.cunsultService.entity.form.ClienteUpdateForm;

import java.util.List;

public interface IClienteService {

    Cliente create(ClienteForm form);

    Cliente get(Long id);

    List<Cliente> getAll();

    Cliente update(Long id, ClienteUpdateForm updateForm);

    void delete(long id);
}
