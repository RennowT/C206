package com.corretora.dao;

import com.corretora.conexao.ConexaoMySQL;
import com.corretora.model.Corretor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorretorDAO extends ConexaoMySQL<Corretor> {
    @Override
    protected void setInsertValues(PreparedStatement pst, Corretor corretor) throws SQLException {
        pst.setString(1, corretor.getCpf());
        pst.setString(2, corretor.getNome());
        pst.setString(3, corretor.getTelefone());
        pst.setString(4, corretor.getEmail());
        pst.setDouble(5, corretor.getTaxaDeComissao());
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO corretor (cpf, nome,  telefone, email, taxaDeComissao) VALUES (?,?,?,?,?)";
    }

    @Override
    protected String buildSelectQuery() {
        return "SELECT * FROM corretor";
    }

    @Override
    protected Corretor createFromResultSet(ResultSet resultSet) throws SQLException {
        return new Corretor(
                resultSet.getInt("id"),
                resultSet.getString("cpf"),
                resultSet.getString("nome"),
                resultSet.getString("telefone"),
                resultSet.getString("email"),
                resultSet.getDouble("taxaDeComissao")
        );
    }

    @Override
    protected String buildSelectQuery(String campo) {
        return "SELECT * FROM corretor WHERE " + campo + " = ?";
    }
}
