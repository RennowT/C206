package com.corretora.model.imovel;

import com.corretora.model.Endereco.Endereco;

import java.math.BigDecimal;

public class Imovel {
    private int codigo;
    private String titulo;
    private String descricao;
    private int numeroDeQuartos;
    private int numeroDeBanheiros;
    private int numeroDeSuites;
    private int numeroDeVagasNaGaragem;
    private double area;
    private BigDecimal valor;
    private String tipo;
    private String finalidade;
    private Endereco endereco;
    private boolean exibir = false;
    private int idCliente;

    public Imovel(
            String titulo,
            String descricao,
            int numeroDeQuartos,
            int numeroDeBanheiros,
            int numeroDeSuites,
            int numeroDeVagasNaGaragem,
            double area,
            BigDecimal valor,
            String tipo,
            String finalidade,
            Endereco endereco,
            int isCliente
    ) {
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
        this.idCliente = isCliente;
    }

    public Imovel(
            int codigo,
            String titulo,
            String descricao,
            int numeroDeQuartos,
            int numeroDeBanheiros,
            int numeroDeSuites,
            int numeroDeVagasNaGaragem,
            double area,
            BigDecimal valor,
            String tipo,
            String finalidade,
            Endereco endereco,
            boolean exibir,
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
        this.exibir = exibir;
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "║\n" +
                "║ ║ ╔════════════════════════════════════════════════════════════════════════╗\n" +
                "║ ║ ║          " + titulo.toUpperCase() + "\n" +
                "║ ║ ╠════════════════════════════════════════════════════════════════════════╣\n" +
                "║ ║ ║   Código: " + codigo + "\n" +
                "║ ║ ║   Descrição: \n" +
                formatarTexto(descricao) + "\n" +
                "║ ║ ║\n" +
                "║ ║ ║   Quartos: " + numeroDeQuartos + "\tBanheiros: " + numeroDeBanheiros +
                "\tSuítes: " + numeroDeSuites + "\tVagas na Garagem: " + numeroDeVagasNaGaragem + "\n" +
                "║ ║ ║   Área: " + area + " m²" + "\tValor: R$ " + valor + "\n" +
                "║ ║ ║   Tipo: " + tipo + "\tFinalidade: " + finalidade + "\n" +
                "║ ║ ║\n" +
                "║ ║ ║   Endereço: \n" +
                formatarTexto(endereco.toString()) + "\n" +
                "║ ║ ╚════════════════════════════════════════════════════════════════════════╝";
    }

    private String formatarTexto(String texto) {
        int maxCaracteresPorLinha = 63;
        StringBuilder sb = new StringBuilder();
        int length = texto.length();
        for (int i = 0; i < length; i += maxCaracteresPorLinha) {
            sb.append("║ ║ ║      ");
            if (i + maxCaracteresPorLinha < length) {
                sb.append(texto, i, i + maxCaracteresPorLinha).append("\n");
            } else {
                sb.append(texto, i, length);
            }
        }
        return sb.toString();
    }

    public int getCodigo() {
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

    public BigDecimal getValor() {
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

    public boolean isExibir() {
        return exibir;
    }

    public int getIdCliente() {
        return idCliente;
    }
}
