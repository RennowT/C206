package com.corretora.dao;

import com.corretora.conexao.ConexaoMySQL;
import com.corretora.model.Endereco;
import com.corretora.model.Imovel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImovelDAO extends ConexaoMySQL<Imovel> {

    @Override
    protected void setInsertValues(PreparedStatement pst, Imovel imovel) throws SQLException {
        pst.setString(1, imovel.getCodigo());
        pst.setString(2, imovel.getTitulo());
        pst.setString(3, imovel.getDescricao());
        pst.setInt(4, imovel.getNumeroDeQuartos());
        pst.setInt(5, imovel.getNumeroDeBanheiros());
        pst.setInt(6, imovel.getNumeroDeSuites());
        pst.setInt(7, imovel.getNumeroDeVagasNaGaragem());
        pst.setDouble(8, imovel.getArea());
        pst.setString(9, imovel.getValor());
        pst.setString(10, imovel.getTipo());
        pst.setString(11, imovel.getFinalidade());
        pst.setString(12, imovel.getEndereco().getLogradouro());
        pst.setString(13, imovel.getEndereco().getNumero());
        pst.setString(14, imovel.getEndereco().getComplemento());
        pst.setString(15, imovel.getEndereco().getBairro());
        pst.setString(16, imovel.getEndereco().getCidade());
        pst.setString(17, imovel.getEndereco().getEstado());
        pst.setString(18, imovel.getEndereco().getCep());
        pst.setInt(19, imovel.getIdCliente());
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO imovel (codigo, titulo, descricao, numeroDeQuartos, numeroDeBanheiros, " +
                "numeroDeSuites, numeroDeVagasNaGaragem, area, valor, tipo, finalidade, logradouro, numero, " +
                "complemento, bairro, cidade, estado, cep, Cliente_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String buildSelectQuery() {
        return "SELECT * FROM imovel";
    }

    @Override
    protected Imovel createFromResultSet(ResultSet resultSet) throws SQLException {
        Endereco endereco = new Endereco(
                resultSet.getString("logradouro"),
                resultSet.getString("numero"),
                resultSet.getString("complemento"),
                resultSet.getString("bairro"),
                resultSet.getString("cidade"),
                resultSet.getString("estado"),
                resultSet.getString("cep")
        );

        return new Imovel(
                resultSet.getString("codigo"),
                resultSet.getString("titulo"),
                resultSet.getString("descricao"),
                resultSet.getInt("numeroDeQuartos"),
                resultSet.getInt("numeroDeBanheiros"),
                resultSet.getInt("numeroDeSuites"),
                resultSet.getInt("numeroDeVagasNaGaragem"),
                resultSet.getDouble("area"),
                resultSet.getString("valor"),
                resultSet.getString("tipo"),
                resultSet.getString("finalidade"),
                endereco,
                resultSet.getInt("Cliente_id")
        );
    }

    @Override
    protected String buildSelectQuery(String campo) {
        return "SELECT * FROM imovel WHERE " + campo + " = ?";
    }

    public boolean verificarImovel(String codigoImovel) {
        connect();

        boolean sucesso = false;
        String sql = "SELECT COUNT(*) AS codigo_count FROM imovel WHERE codigo = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, codigoImovel);
            resultSet = pst.executeQuery();

            resultSet.next();
            int count = resultSet.getInt("codigo_count");
            sucesso = count > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao executar SQL: " + e.getMessage());
        } finally {
            closeResources();
        }

        return sucesso;
    }
}