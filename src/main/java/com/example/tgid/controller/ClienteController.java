package com.example.tgid.controller;


import com.example.tgid.model.Cliente;
import com.example.tgid.dto.ClienteListagemDTO;
import com.example.tgid.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClienteListagemDTO>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        List<ClienteListagemDTO> clientesDTO = clientes.stream()
                .map(p -> modelMapper.map(p, ClienteListagemDTO.class)).toList();
        return ResponseEntity.ok(clientesDTO);
    }

}