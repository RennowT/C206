package com.corretora.dao;

import com.corretora.conexao.ConexaoMySQL;
import com.corretora.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends ConexaoMySQL<Cliente> {
    @Override
    protected void setInsertValues(PreparedStatement pst, Cliente cliente) throws SQLException {
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getEmail());
        pst.setString(3, cliente.getHashUsuario());
        pst.setString(4, cliente.getTelefone());
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO cliente (nome, email, hashUsuario, telefone) VALUES (?,?,?,?)";
    }

    @Override
    protected String buildSelectQuery() {
        return "SELECT * FROM cliente";
    }

    @Override
    protected Cliente createFromResultSet(ResultSet resultSet) throws SQLException {
        return new Cliente(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("email"),
                resultSet.getString("hashUsuario"),
                resultSet.getString("telefone")
        );
    }

    @Override
    protected String buildSelectQuery(String campo) {
        return "SELECT * FROM cliente WHERE " + campo + " = ?";
    }

    public boolean verificarEmailCadastrado(String email) {
        connect();

        boolean sucesso = false;
        String sql = "SELECT COUNT(*) AS email_count FROM cliente WHERE email = ?";

        return verificaEmailNoBD(sql, email);
    }
}