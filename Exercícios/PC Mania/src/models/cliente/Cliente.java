package models.cliente;

import models.computador.Computador;

public class Cliente {
    private String nome;
    private long cpf;

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public float calculaTotalCompra(Computador[] computadores) {
        float soma = 0;
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] != null) {
                soma += computadores[i].getValor();
            }
        }

        return soma;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }
}
