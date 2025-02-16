// src/main/java/br/edu/ifpr/pgua/eic/tads/dao/DisciplinaDAO.java

package br.edu.ifpr.pgua.eic.tads.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.pgua.eic.tads.models.Disciplina;
import br.edu.ifpr.pgua.eic.tads.models.Professor;

public class DisciplinaDAO {

    public void inserirDisciplina(Disciplina disciplina) throws SQLException {
        String sql = "INSERT INTO disciplina (nome, ementa, carga_horaria, professor_id) VALUES (?,?,?,?)";
        
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, disciplina.getNome());
            ps.setString(2, disciplina.getEmenta());
            ps.setInt(3, disciplina.getCargaHoraria());
            ps.setInt(4, disciplina.getProfessor().getId());
            
            ps.executeUpdate();
        }
    }

   
}