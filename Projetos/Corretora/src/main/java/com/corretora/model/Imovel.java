package com.corretora.model;

public class Imovel {
    private String codigo;
    private String titulo;
    private String descricao;
    private int numeroDeQuartos;
    private int numeroDeBanheiros;
    private int numeroDeSuites;
    private int numeroDeVagasNaGaragem;
    private double area;
    private String valor;
    private String tipo;
    private String finalidade;
    private Endereco endereco;
    private int idCliente;

    public Imovel(
            String codigo,
            String titulo,
            String descricao,
            int numeroDeQuartos,
            int numeroDeBanheiros,
            int numeroDeSuites,
            int numeroDeVagasNaGaragem,
            double area,
            String valor,
            String tipo,
            String finalidade,
            Endereco endereco,
            int idCliente
    ) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroDeQuartos = numeroDeQuartos;
        this.numeroDeBanheiros = numeroDeBanheiros;
        this.numeroDeSuites = numeroDeSuites;
        this.numeroDeVagasNaGaragem = numeroDeVagasNaGaragem;
        this.area = area;
        this.valor = valor;
        this.tipo = tipo;
        this.finalidade = finalidade;
        this.endereco = endereco;
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", numeroDeQuartos=" + numeroDeQuartos +
                ", numeroDeBanheiros=" + numeroDeBanheiros +
                ", numeroDeSuites=" + numeroDeSuites +
                ", numeroDeVagasNaGaragem=" + numeroDeVagasNaGaragem +
                ", area=" + area +
                ", valor=" + valor +
                ", tipo='" + tipo + '\'' +
                ", finalidade='" + finalidade + '\'' +
                ", endereco=" + endereco +
                ", idCliente=" + idCliente +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getNumeroDeQuartos() {
        return numeroDeQuartos;
    }

    public int getNumeroDeBanheiros() {
        return numeroDeBanheiros;
    }

    public int getNumeroDeSuites() {
        return numeroDeSuites;
    }

    public int getNumeroDeVagasNaGaragem() {
        return numeroDeVagasNaGaragem;
    }

    public double getArea() {
        return area;
    }

    public String getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getIdCliente() {
        return idCliente;
    }
}
