package br.edu.ifpr.pgua.eic.tads.controllers;

import java.sql.SQLException;

import br.edu.ifpr.pgua.eic.tads.dao.DisciplinaDAO;
import br.edu.ifpr.pgua.eic.tads.dao.ProfessorDAO;
import br.edu.ifpr.pgua.eic.tads.models.Disciplina;
import br.edu.ifpr.pgua.eic.tads.models.Professor;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DisciplinaController {

    private static DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    private static ProfessorDAO professorDAO = new ProfessorDAO();

    public static Handler mostrarFormulario = (Context ctx) -> {
        ctx.render("templates/cadastro/cadastroDisciplina.html");
    };

    public static void inserirDisciplina(Context ctx) throws SQLException {
        String nome = ctx.formParam("nome");
            String ementa = ctx.formParam("ementa");
            int cargaHoraria = Integer.parseInt(ctx.formParam("cargaHoraria"));
            int professorId = Integer.parseInt(ctx.formParam("professorId")); // ID digitado pelo usuário

            Professor professor = professorDAO.buscarProfessor(professorId);
            
            if (professor == null) {
                ctx.status(400).result("Professor não encontrado! Verifique o ID.");
                return;
            }

            Disciplina disciplina = new Disciplina();
            disciplina.setNome(nome);
            disciplina.setEmenta(ementa);
            disciplina.setCargaHoraria(cargaHoraria);
            disciplina.setProfessor(professor); 

            disciplinaDAO.inserirDisciplina(disciplina);

            ctx.redirect("/cadastro.html");
   
}
}