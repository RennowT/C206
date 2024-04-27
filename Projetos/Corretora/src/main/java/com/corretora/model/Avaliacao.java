package com.corretora.model;

public class Avaliacao {
    private int id;
    private int estrelas;
    private String comentario;
    private int clienteId;

    public Avaliacao(int id, int estrelas, String comentario, int clienteId) {
        this.id = id;
        this.estrelas = estrelas;
        this.comentario = comentario;
        this.clienteId = clienteId;
    }

    public Avaliacao(int estrelas, String comentario, int clienteId) {
        this.estrelas = estrelas;
        this.comentario = comentario;
        this.clienteId = clienteId;
    }

    public int getId() {
        return id;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public String getComentario() {
        return comentario;
    }

    public int getClienteId() {
        return clienteId;
    }
}
