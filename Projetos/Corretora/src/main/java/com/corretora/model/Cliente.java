package com.corretora.model;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String hashUsuario;
    private String telefone;
    private ArrayList<Avaliacao> listaDeAvaliacoes;

    public Cliente(String nome, String email, String hashUsuario, String telefone) {
        this.nome = nome;
        this.email = email;
        this.hashUsuario = hashUsuario;
        this.telefone = telefone;
    }

    public Cliente(int id, String nome, String email, String hashUsuario, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.hashUsuario = hashUsuario;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getHashUsuario() {
        return hashUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
