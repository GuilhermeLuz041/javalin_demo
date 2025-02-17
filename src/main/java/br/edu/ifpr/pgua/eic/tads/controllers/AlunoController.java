package br.edu.ifpr.pgua.eic.tads.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifpr.pgua.eic.tads.dao.AlunoDAO;
import br.edu.ifpr.pgua.eic.tads.models.Aluno;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AlunoController {
    private static AlunoDAO alunoDAO = new AlunoDAO();

    public static Handler mostrarFormulario = (Context ctx) -> {
        ctx.render("templates/cadastro/cadastroAluno.html");
    };

    public static void mostrarFormularioExclusao(Context ctx) {
        ctx.render("templates/remover/removerAluno.html"); 
    }

    public static void processarExclusao(Context ctx) {
        String idStr = ctx.formParam("id");

        if (idStr == null || idStr.trim().isEmpty()) {
            ctx.status(400).result("ID do aluno não informado.");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            alunoDAO.removerAluno(id);
            ctx.result("Aluno excluído com sucesso!");
        } catch (NumberFormatException e) {
            ctx.status(400).result("ID inválido.");
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(500).result("Erro ao excluir o aluno.");
        }
    }

    public static void inserirAluno(Context ctx) {
        Aluno aluno = new Aluno();
        aluno.setNome(ctx.formParam("nome"));
        aluno.setMatricula(ctx.formParam("matricula"));
        aluno.setCpf(ctx.formParam("cpf"));
        aluno.setDataNascimento(LocalDate.parse(ctx.formParam("dataNascimento")));
        aluno.setEndereco(ctx.formParam("endereco"));
        aluno.setTelefone(ctx.formParam("telefone"));
        aluno.setEmail(ctx.formParam("email"));
            
        alunoDAO.inserirAluno(aluno);
        ctx.redirect("/cadastro.html");
    }

    public static void listarAlunosView(Context ctx) {
        List<Aluno> alunos = alunoDAO.listarAlunos(); 
        Map<String, Object> model = new HashMap<>();
        model.put("alunos", alunos); 
        ctx.render("templates/lista/listaAlunos.html", model);
    }
    
    
    public static void excluirAluno(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        alunoDAO.removerAluno(id);
        ctx.redirect("/remover.html");
    }
}