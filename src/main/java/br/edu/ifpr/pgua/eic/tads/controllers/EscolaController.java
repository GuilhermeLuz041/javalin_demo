package br.edu.ifpr.pgua.eic.tads.controllers;

import br.edu.ifpr.pgua.eic.tads.dao.EscolaDAO;
import br.edu.ifpr.pgua.eic.tads.models.Escola;
import io.javalin.http.Context;

public class EscolaController {
    private static EscolaDAO escolaDAO = new EscolaDAO();


    public static void inserirEscola(Context ctx) {
        Escola escola = new Escola();
        escola.setNome(ctx.formParam("nome"));
        escola.setEndereco(ctx.formParam("endereco"));
        escola.setContato(ctx.formParam("Contato"));
        
        escolaDAO.inserirEscola(escola);
        ctx.redirect("/cadastro.html");
    }
}