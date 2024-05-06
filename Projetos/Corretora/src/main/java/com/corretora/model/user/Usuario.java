package com.corretora.model.user;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String hashUsuario;
    protected String telefone;

    public Usuario(String nome, String email, String hashUsuario, String telefone) {
        this.nome = nome;
        this.email = email;
        this.hashUsuario = hashUsuario;
        this.telefone = telefone;
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

    public abstract boolean verificarEmailCadastrado(String email);
}
