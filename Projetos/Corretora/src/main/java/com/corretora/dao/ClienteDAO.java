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
        pst.setString(3, cliente.getTelefone());
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO cliente (nome, email, telefone) VALUES (?,?,?)";
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
                resultSet.getString("telefone")
        );
    }

    @Override
    protected String buildSelectQuery(String campo) {
        return "SELECT * FROM cliente WHERE " + campo + " = ?";
    }

    public boolean verificarCliente(String email) {
        connect();

        boolean sucesso = false;
        String sql = "SELECT COUNT(*) AS email_count FROM cliente WHERE email = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, email);
            resultSet = pst.executeQuery();

            resultSet.next();
            int count = resultSet.getInt("email_count");
            sucesso = count > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao executar SQL: " + e.getMessage());
        } finally {
            closeResources();
        }

        return sucesso;
    }
}