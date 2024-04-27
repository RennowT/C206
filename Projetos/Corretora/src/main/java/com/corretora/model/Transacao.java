package com.corretora.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transacao {
    private int id;
    private Date dataDaTransacao;
    private String tipo;
    private BigDecimal valor;
    private String codigoDoImovel;
    private int idCliente;
    private int idCorretor;

    public Transacao(
            int id,
            Date dataDaTransacao,
            String tipo, BigDecimal valor,
            String codigoDoImovel,
            int idCliente,
            int idCorretor
    ) {
        this.id = id;
        this.dataDaTransacao = dataDaTransacao;
        this.tipo = tipo;
        this.valor = valor;
        this.codigoDoImovel = codigoDoImovel;
        this.idCliente = idCliente;
        this.idCorretor = idCorretor;
    }

    public Transacao(
            Date dataDaTransacao,
            String tipo,
            BigDecimal valor,
            String codigoDoImovel,
            int idCliente,
            int idCorretor
    ) {
        this.dataDaTransacao = dataDaTransacao;
        this.tipo = tipo;
        this.valor = valor;
        this.codigoDoImovel = codigoDoImovel;
        this.idCliente = idCliente;
        this.idCorretor = idCorretor;
    }

    public int getId() {
        return id;
    }

    public Date getDataDaTransacao() {
        return dataDaTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getCodigoDoImovel() {
        return codigoDoImovel;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdCorretor() {
        return idCorretor;
    }
}
