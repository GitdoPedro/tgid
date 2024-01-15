package com.example.tgid.controller;


import com.example.tgid.model.Transacao;
import com.example.tgid.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping("/{tipo}")
    public ResponseEntity<String> efetuarTransacao(@RequestBody @Valid Transacao transacao,
                                                   @PathVariable String tipo) {
        if ("deposito".equalsIgnoreCase(tipo)) {
            return transacaoService.depositar(transacao);
        } else if ("saque".equalsIgnoreCase(tipo)) {
            return transacaoService.sacar(transacao);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de transação inválido");
        }
    }


    }
