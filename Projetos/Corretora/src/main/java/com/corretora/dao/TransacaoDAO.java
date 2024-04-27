package com.corretora.dao;

import com.corretora.conexao.ConexaoMySQL;
import com.corretora.model.Transacao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransacaoDAO extends ConexaoMySQL<Transacao> {
    @Override
    protected void setInsertValues(PreparedStatement pst, Transacao transacao) throws SQLException {
        pst.setDate(1, (Date) transacao.getDataDaTransacao());
        pst.setString(2, transacao.getTipo());
        pst.setBigDecimal(3, transacao.getValor());
        pst.setString(4, transacao.getCodigoDoImovel());
        pst.setInt(5, transacao.getIdCliente());
        pst.setInt(6, transacao.getIdCorretor());
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO transacao (dataDaTransacao, tipo, valor, Imovel_codigo, Cliente_id, Corretor_id) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?)"  ;
    }

    @Override
    protected String buildSelectQuery() {
        return "SELECT * FROM transacao";
    }

    @Override
    protected Transacao createFromResultSet(ResultSet resultSet) throws SQLException {
        return new Transacao(
                resultSet.getInt("id"),
                resultSet.getDate("dataDaTransacao"),
                resultSet.getString("tipo"),
                resultSet.getBigDecimal("valor"),
                resultSet.getString("Imovel_codigo"),
                resultSet.getInt("Cliente_id"),
                resultSet.getInt("Corretor_id")
        );
    }

    @Override
    protected String buildSelectQuery(String campo) {
        return "SELECT * FROM transacao WHERE " + campo + " = ?";
    }
}
