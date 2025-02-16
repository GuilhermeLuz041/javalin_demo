package br.edu.ifpr.pgua.eic.tads.controllers;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class IndexController {

    public static Handler index = (Context ctx) -> {
        ctx.render("index.html"); 
    };
}