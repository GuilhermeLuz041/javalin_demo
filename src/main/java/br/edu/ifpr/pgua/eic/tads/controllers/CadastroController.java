// CadastroController.java
package br.edu.ifpr.pgua.eic.tads.controllers;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class CadastroController {
    public static Handler mostrarPaginaCadastro = (Context ctx) -> {
        ctx.render("/public/cadastro.html");
    };
}