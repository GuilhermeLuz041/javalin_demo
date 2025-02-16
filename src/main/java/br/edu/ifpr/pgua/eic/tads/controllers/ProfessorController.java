package br.edu.ifpr.pgua.eic.tads.controllers;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpr.pgua.eic.tads.dao.ProfessorDAO;
import br.edu.ifpr.pgua.eic.tads.models.Professor;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ProfessorController {

    private static ProfessorDAO professorDAO = new ProfessorDAO();

    public static Handler mostrarFormulario = (Context ctx) -> {
        ctx.render("templates/cadastro/cadastroProfessor.html");
    };
    
    public static void inserirProfessor(Context ctx) {
        Professor prof = new Professor();
        prof.setSiape(ctx.formParam("siape"));
        prof.setNome(ctx.formParam("nome"));
        prof.setCpf(ctx.formParam("cpf"));
        prof.setDataNascimento(LocalDate.parse(ctx.formParam("dataNascimento")));
        prof.setEndereco(ctx.formParam("endereco"));
        prof.setTelefone(ctx.formParam("telefone"));
        prof.setEmail(ctx.formParam("email"));

        professorDAO.inserirProfessor(prof);
        ctx.redirect("/cadastro.html");
    }

    public static void listarProfessores(Context ctx) {
        List<Professor> lista = professorDAO.listarProfessores();
        ctx.json(lista);
    }

    public static void buscarProfessor(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Professor prof = professorDAO.buscarProfessor(id);
        if (prof != null) {
            ctx.json(prof);
        } else {
            ctx.status(404).result("Professor não encontrado");
        }
    }


    /*public static void excluirProfessor(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        professorDAO.excluirProfessor(id);
        ctx.redirect("/professores");
    } */

}
