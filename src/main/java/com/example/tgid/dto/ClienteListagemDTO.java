package com.example.tgid.dto;

public class ClienteListagemDTO {

    private Integer id;
    private String cpf;
    private String nome;

    public ClienteListagemDTO(Integer id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public ClienteListagemDTO() {}

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
