package com.corretora.model.user;

import com.corretora.dao.usuario.ClienteDAO;
import com.corretora.model.Avaliacao;

import java.util.ArrayList;

public class Cliente extends Usuario {
    private int id;
    private ArrayList<Avaliacao> listaDeAvaliacoes;
    private ClienteDAO clienteDAO;

    public Cliente(String nome, String email, String hashUsuario, String telefone) {
        super(nome, email, hashUsuario, telefone);
        this.clienteDAO = new ClienteDAO();
    }

    public Cliente(int id, String nome, String email, String hashUsuario, String telefone) {
        super(nome, email, hashUsuario, telefone);
        this.id = id;
        this.clienteDAO = new ClienteDAO();
    }

    public int getId() {
        return id;
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

    public boolean verificarEmailCadastrado(String email) {
        return clienteDAO.verificar("email", email);
    }

    public boolean inserir() {
        return clienteDAO.inserir(this);
    }
}
