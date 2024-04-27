package com.corretora.dao;

import com.corretora.conexao.ConexaoMySQL;
import com.corretora.model.Avaliacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaliacaoDAO extends ConexaoMySQL<Avaliacao> {
    @Override
    protected void setInsertValues(PreparedStatement pst, Avaliacao avaliacao) throws SQLException {
        pst.setInt(1, avaliacao.getEstrelas());
        pst.setString(2, avaliacao.getComentario());
        pst.setInt(3, avaliacao.getClienteId());
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO avaliacao (estrelas, comentario, Cliente_id) VALUES (?,?,?)";
    }

    @Override
    protected String buildSelectQuery() {
        return "SELECT * FROM avaliacao";
    }

    @Override
    protected Avaliacao createFromResultSet(ResultSet resultSet) throws SQLException {
        return new Avaliacao(
                resultSet.getInt("id"),
                resultSet.getInt("estrelas"),
                resultSet.getString("comentario"),
                resultSet.getInt("Cliente_id")
        );
    }

    @Override
    protected String buildSelectQuery(String campo) {
        return "SELECT * FROM avaliacao WHERE " + campo + " = ?"    ;
    }
}