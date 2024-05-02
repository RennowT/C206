package com.corretora.model.Endereco;

public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String cidade,
            String estado,
            String cep
    ) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!logradouro.trim().isEmpty()) {
            sb.append(logradouro);
        }
        if (!numero.trim().isEmpty()) {
            sb.append(", nº").append(numero);
        }
        if (!complemento.trim().isEmpty()) {
            sb.append(", ").append(complemento);
        }
        if (!bairro.trim().isEmpty()) {
            sb.append(", Bairro ").append(bairro);
        }
        if (!cidade.trim().isEmpty()) {
            sb.append(", ").append(cidade);
        }
        if (!estado.trim().isEmpty()) {
            sb.append(", ").append(estado);
        }
        if (!cep.trim().isEmpty()) {
            sb.append(", ").append(cep);
        }

        return sb.toString();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }
}
