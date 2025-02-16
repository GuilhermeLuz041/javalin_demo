package br.edu.ifpr.pgua.eic.tads.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    private static final String URL = "jdbc:mysql://wagnerweinert.com.br:3306/tads24_guilherme";
    private static final String USER = "tads24_guilherme";
    private static final String PASSWORD = "tads24_guilherme";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

