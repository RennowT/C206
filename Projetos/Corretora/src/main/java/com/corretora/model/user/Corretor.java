package com.corretora.model.user;

import com.corretora.dao.usuario.CorretorDAO;

public class Corretor extends Usuario {
    private String creci;
    private String cpf;
    private double taxaDeComissao = 0.05f;

    public Corretor(String nome, String email, String hashUsuario, String telefone, String cpf, String creci) {
        super(nome, email, hashUsuario, telefone);
        this.creci = creci;
        this.cpf = cpf;
    }

    public Corretor(String nome, String email, String hashUsuario, String telefone, String creci, String cpf, double taxaDeComissao) {
        super(nome, email, hashUsuario, telefone);
        this.creci = creci;
        this.cpf = cpf;
        this.taxaDeComissao = taxaDeComissao;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCreci() {
        return creci;
    }

    public double getTaxaDeComissao() {
        return taxaDeComissao;
    }

    @Override
    public boolean verificarEmailCadastrado(String email) {
        CorretorDAO corretorDAO = new CorretorDAO();
        return corretorDAO.verificar("email", email);
    }

    public boolean verificarCRECI(String creci) {
        CorretorDAO corretorDAO = new CorretorDAO();
        return corretorDAO.verificar("creci", creci);
    }

    public boolean inserir() {
        CorretorDAO corretorDAO = new CorretorDAO();
        return corretorDAO.inserir(this);
    }
}
