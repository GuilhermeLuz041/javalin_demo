package br.edu.ifpr.pgua.eic.tads;


import br.edu.ifpr.pgua.eic.tads.controllers.AlunoController;
import br.edu.ifpr.pgua.eic.tads.controllers.CadastroController;
import br.edu.ifpr.pgua.eic.tads.controllers.DisciplinaController;
import br.edu.ifpr.pgua.eic.tads.controllers.EscolaController;
import br.edu.ifpr.pgua.eic.tads.controllers.ProfessorController;
import br.edu.ifpr.pgua.eic.tads.utils.JavalinUtils;

public class App {
    public static void main( String[] args ){
        var app = JavalinUtils.makeApp(7070);

        app.get("/", ctx -> ctx.redirect("/index.html"));
        app.get("/cadastroEscola", ctx -> ctx.render("/public/templates/cadastro/cadastroEscola.html"));
        app.post("/escolas", EscolaController::inserirEscola);
        
        app.get("/cadastro", CadastroController.mostrarPaginaCadastro);

        app.get("/cadastroAluno", AlunoController.mostrarFormulario);
        app.post("/alunos", AlunoController::inserirAluno);
        
        app.get("/cadastroProfessor", ProfessorController.mostrarFormulario);
        app.post("/professores", ProfessorController::inserirProfessor);
        
        app.get("/cadastroDisciplina", DisciplinaController.mostrarFormulario);
        app.post("/disciplinas", DisciplinaController::inserirDisciplina);

        app.get("/listaAlunos", AlunoController::listarAlunosView);


        app.start();
    }
}