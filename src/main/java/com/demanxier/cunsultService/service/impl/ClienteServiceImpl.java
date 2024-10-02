package com.demanxier.cunsultService.service.impl;

import com.demanxier.cunsultService.entity.Cliente;
import com.demanxier.cunsultService.entity.Empresa;
import com.demanxier.cunsultService.entity.form.ClienteForm;
import com.demanxier.cunsultService.entity.form.ClienteUpdateForm;
import com.demanxier.cunsultService.repository.ClienteRepository;
import com.demanxier.cunsultService.repository.EmpresaRepository;
import com.demanxier.cunsultService.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Cliente create(ClienteForm form) {
        Empresa empresa = empresaRepository.findById(form.getId_empresa())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada."));

        Cliente cliente = new Cliente();
        cliente.setNome(form.getNome());
        cliente.setEmail(form.getEmail());
        cliente.setSenha(form.getSenha());

        cliente.setEmpresa(empresa);

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente get(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente update(Long id, ClienteUpdateForm updateForm) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        cliente.setSenha(updateForm.getSenha());
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cliente não encontrado"));

        clienteRepository.delete(cliente);
    }
}
