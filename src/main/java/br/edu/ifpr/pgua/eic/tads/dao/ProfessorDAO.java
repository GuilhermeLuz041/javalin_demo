package br.edu.ifpr.pgua.eic.tads.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.pgua.eic.tads.models.Professor;


public class ProfessorDAO {

    public void inserirProfessor(Professor professor) {
        String sql = "INSERT INTO professor (siape, nome, cpf, data_nascimento, endereco, telefone, email) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, professor.getSiape());
            ps.setString(2, professor.getNome());
            ps.setString(3, professor.getCpf());
            ps.setDate(4, Date.valueOf(professor.getDataNascimento()));
            ps.setString(5, professor.getEndereco());
            ps.setString(6, professor.getTelefone());
            ps.setString(7, professor.getEmail());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Professor> listarProfessores() {
        List<Professor> lista = new ArrayList<>();
        String sql = "SELECT * FROM professor";
        try (Connection conn = FabricaConexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Professor p = new Professor();
                p.setId(rs.getInt("id"));
                p.setSiape(rs.getString("siape"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setEmail(rs.getString("email"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static Professor buscarProfessor(int id) {
        Professor p = null;
        String sql = "SELECT * FROM professor WHERE id = ?";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Professor();
                p.setId(rs.getInt("id"));
                p.setSiape(rs.getString("siape"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void excluirProfessor(int id) {
        String sql = "DELETE FROM professor WHERE id = ?";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
