package com.corretora.model;

public class Corretor {
    private int id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private double taxaDeComissao;

    public Corretor(String cpf, String nome, String telefone, String email, double taxaDeComissao) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.taxaDeComissao = taxaDeComissao;
    }

    public Corretor(int id, String cpf, String nome, String telefone, String email, double taxaDeComissao) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.taxaDeComissao = taxaDeComissao;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public double getTaxaDeComissao() {
        return taxaDeComissao;
    }
}
