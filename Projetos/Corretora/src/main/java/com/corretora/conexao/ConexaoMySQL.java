package com.corretora.conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ConexaoMySQL<T> {
    protected static Connection connection;
    protected static Statement statement;
    protected static ResultSet resultSet;
    protected static PreparedStatement pst;

    private static final String USER = "root";
    private static final String PASS = "1qaz2wsx";
    private static final String DATABASE = "Corretora";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/" + DATABASE + "?useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException  e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    protected void closeResources() {
        try {
            connection.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }

    public boolean inserir(T item) {
        connect();

        boolean sucesso = false;
        String sql = buildInsertQuery();

        try {
            pst = connection.prepareStatement(sql);
            setInsertValues(pst, item);
            pst.execute();
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        } finally {
            closeResources();
        }

        return sucesso;
    }

    protected abstract void setInsertValues(PreparedStatement pst, T item) throws SQLException;

    protected abstract String buildInsertQuery();

    public List<T> selecionarTodos() {
        connect();

        List<T> itens = new ArrayList<>();
        String sql = buildSelectQuery();

        try {
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                T item = createFromResultSet(resultSet);
                itens.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        } finally {
            closeResources();
        }

        return itens;
    }

    protected abstract String buildSelectQuery();

    public List<T> selecionarPor(String campo, String valor) {
        connect();

        List<T> itens = new ArrayList<>();
        String sql = buildSelectQuery(campo);

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, valor);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                T item = createFromResultSet(resultSet);
                itens.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar itens: " + e.getMessage());
        } finally {
            closeResources();
        }

        return itens;
    }

    protected abstract T createFromResultSet(ResultSet resultSet) throws SQLException;

    protected abstract String buildSelectQuery(String campo);

    public boolean verificaEmailNoBD(String email, String sql) {
        boolean sucesso = false;
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
