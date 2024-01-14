package com.example.tgid.service;


import com.example.tgid.model.Cliente;
import com.example.tgid.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Cliente> listarClientes() {
        List<Cliente> clientes;
        clientes = clienteRepository.findAll();

        return clientes;

    }
}
