package br.edu.ifpr.pgua.eic.tads.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.pgua.eic.tads.models.Aluno;

public class AlunoDAO {

    public void inserirAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno (matricula, nome, cpf, data_nascimento, endereco, telefone, email) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, aluno.getMatricula());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getCpf());
            ps.setDate(4, Date.valueOf(aluno.getDataNascimento()));
            ps.setString(5, aluno.getEndereco());
            ps.setString(6, aluno.getTelefone());
            ps.setString(7, aluno.getEmail());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try (Connection conn = FabricaConexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setMatricula(rs.getString("matricula"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                a.setEndereco(rs.getString("endereco"));
                a.setTelefone(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Aluno buscarAluno(int id) {
        Aluno a = null;
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setMatricula(rs.getString("matricula"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                a.setEndereco(rs.getString("endereco"));
                a.setTelefone(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public void excluirAluno(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
