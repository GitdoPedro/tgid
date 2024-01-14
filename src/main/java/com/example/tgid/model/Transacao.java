package com.example.tgid.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "trancacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean deposito;
    private Boolean saque;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Boolean statusConcluido;

    public Transacao(Integer id, Boolean deposito, Boolean saque,
                     BigDecimal valor, LocalDateTime dataHora, Empresa empresa,
                     Cliente cliente, Boolean statusConcluido) {
        this.id = id;
        this.deposito = deposito;
        this.saque = saque;
        this.valor = valor;
        this.dataHora = dataHora;
        this.empresa = empresa;
        this.cliente = cliente;
        this.statusConcluido = statusConcluido;
    }

    public Transacao() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeposito() {
        return deposito;
    }

    public void setDeposito(Boolean deposito) {
        this.deposito = deposito;
    }

    public Boolean getSaque() {
        return saque;
    }

    public void setSaque(Boolean saque) {
        this.saque = saque;
    }

    public BigDecimal  getValor() {
        return valor;
    }

    public void setValor(BigDecimal  valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getStatusConcluido() {
        return statusConcluido;
    }

    public void setStatusConcluido(Boolean statusConcluido) {
        this.statusConcluido = statusConcluido;
    }
}
