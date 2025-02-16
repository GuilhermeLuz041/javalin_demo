package br.edu.ifpr.pgua.eic.tads.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpr.pgua.eic.tads.models.Escola;

public class EscolaDAO {

    public void inserirEscola(Escola escola) {
        String sql = "INSERT INTO escola (nome, endereco, contato) VALUES (?,?,?)";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, escola.getNome());
            ps.setString(2, escola.getEndereco());
            ps.setString(3, escola.getContato());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
