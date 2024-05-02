package com.corretora.dao;

import com.corretora.conexao.ConexaoMySQL;
import com.corretora.model.Corretor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CorretorDAO extends ConexaoMySQL<Corretor> {
    @Override
    protected void setInsertValues(PreparedStatement pst, Corretor corretor) throws SQLException {
        pst.setString(1, corretor.getCreci());
        pst.setString(2, corretor.getCpf());
        pst.setString(3, corretor.getNome());
        pst.setString(4, corretor.getHashUsuario());
        pst.setString(5, corretor.getTelefone());
        pst.setString(6, corretor.getEmail());
        pst.setDouble(7, corretor.getTaxaDeComissao());
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO corretor (creci, cpf, nome, hashUsuario, telefone, email, taxaDeComissao) VALUES (?,?,?,?,?,?,?)";
    }

    @Override
    protected String buildSelectQuery() {
        return "SELECT * FROM corretor";
    }

    @Override
    protected Corretor createFromResultSet(ResultSet resultSet) throws SQLException {
        return new Corretor(
                resultSet.getString("creci"),
                resultSet.getString("cpf"),
                resultSet.getString("nome"),
                resultSet.getString("telefone"),
                resultSet.getString("email"),
                resultSet.getString("hashUsuario"),
                resultSet.getDouble("taxaDeComissao")
        );
    }

    @Override
    protected String buildSelectQuery(String campo) {
        return "SELECT * FROM corretor WHERE " + campo + " = ?";
    }

    public boolean verificarCreciCadastrado(String creci) {
        connect();

        boolean sucesso = false;
        String sql = "SELECT COUNT(*) AS creci_count FROM corretor WHERE creci = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, creci);
            resultSet = pst.executeQuery();

            resultSet.next();
            int count = resultSet.getInt("creci_count");
            sucesso = count > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao executar SQL: " + e.getMessage());
        } finally {
            closeResources();
        }

        return sucesso;
    }

    public boolean verificarEmailCadastrado(String email) {
        connect();
        String sql = "SELECT COUNT(*) AS email_count FROM corretor WHERE email = ?";

        return verificaEmailNoBD(email, sql);
    }

}
