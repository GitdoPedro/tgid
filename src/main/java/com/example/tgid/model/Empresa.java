package com.example.tgid.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(unique = true)
    private String CNPJ;
    private String nome;
    private BigDecimal saldo;

    public Empresa(Integer id, String CNPJ, String nome, BigDecimal  saldo) {
        this.id = id;
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.saldo = saldo;
    }

    public Empresa() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal  getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal  saldo) {
        this.saldo = saldo;
    }
}
