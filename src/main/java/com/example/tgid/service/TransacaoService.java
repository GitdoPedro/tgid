package com.example.tgid.service;

import com.example.tgid.helper.Tarifa;
import com.example.tgid.model.Cliente;
import com.example.tgid.model.Empresa;
import com.example.tgid.model.Transacao;
import com.example.tgid.repository.ClienteRepository;
import com.example.tgid.repository.EmpresaRepository;
import com.example.tgid.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TransacaoService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    TransacaoRepository transacaoRepository;



    public ResponseEntity<String> depositar(Transacao transacao) {
        Cliente clienteEncontrado = clienteRepository.getReferenceById(transacao.getCliente().getId());
        Empresa empresaEncontrada = empresaRepository.getReferenceById(transacao.getEmpresa().getId());

        if(clienteEncontrado == null || empresaEncontrada == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Depósito não efetuado. Cliente ou Empresa não encontrados");
        }

        Tarifa tarifa = new Tarifa(transacao.getValor());

        Transacao transacaoSalva = new Transacao();
        transacaoSalva.setCliente(clienteEncontrado);
        transacaoSalva.setEmpresa(empresaEncontrada);
        transacaoSalva.setValor(tarifa.getValorReajustado());
        transacaoSalva.setDataHora(LocalDateTime.now());
        empresaEncontrada.setSaldo(empresaEncontrada.getSaldo().add(transacaoSalva.getValor()));

        transacaoRepository.save(transacaoSalva);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Depósito efetuado "+ transacaoSalva.getValor().toString()+ " "+
                        "na conta da empresa : "+transacaoSalva.getEmpresa().getNome()+
                        " pelo cliente: "+transacaoSalva.getCliente().getNome());
    }

    public ResponseEntity<String> sacar(Transacao transacao) {
        Cliente clienteEncontrado = clienteRepository.getReferenceById(transacao.getCliente().getId());
        Empresa empresaEncontrada = empresaRepository.getReferenceById(transacao.getEmpresa().getId());

        if (clienteEncontrado == null || empresaEncontrada == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Depósito não efetuado. Cliente ou Empresa não encontrados");
        }

        if (empresaEncontrada.getSaldo().compareTo(transacao.getValor()) < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Depósito não efetuado. Saldo insuficiente");

        }

        Tarifa tarifa = new Tarifa(transacao.getValor());

        Transacao transacaoSalva = new Transacao();
        transacaoSalva.setCliente(clienteEncontrado);
        transacaoSalva.setEmpresa(empresaEncontrada);
        transacaoSalva.setValor(tarifa.getValorReajustado().negate());
        transacaoSalva.setDataHora(LocalDateTime.now());
        empresaEncontrada.setSaldo(empresaEncontrada.getSaldo().add(transacaoSalva.getValor()));

        transacaoRepository.save(transacaoSalva);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Saque efetuado "+ transacaoSalva.getValor().toString()+ " "+
                        "na conta da empresa : "+transacaoSalva.getEmpresa().getNome()+
                        " pelo cliente: "+transacaoSalva.getCliente().getNome());

    }
}
