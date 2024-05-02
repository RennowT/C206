package com.corretora.model;

public class Corretor {
    private String creci;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String hashUsuario;
    private double taxaDeComissao = 0.05f;

    public Corretor(String creci, String cpf, String nome, String telefone, String email, String hashUsuario) {
        this.creci = creci;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.hashUsuario = hashUsuario;
    }

    public Corretor(String creci, String cpf, String nome, String telefone, String email, String hashUsuario, double taxaDeComissao) {
        this.creci = creci;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.hashUsuario = hashUsuario;
        this.taxaDeComissao = taxaDeComissao;
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

    public String getCreci() {
        return creci;
    }

    public String getHashUsuario() {
        return hashUsuario;
    }

    public double getTaxaDeComissao() {
        return taxaDeComissao;
    }
}
