package br.edu.ifpr.pgua.eic.tads.models;

import java.time.LocalDate;

public class Professor extends Pessoa {

    private String siape;

    public Professor(){
    }

    public Professor(int id, String nome, String cpf, LocalDate dataNascimento, String endereco,
                     String telefone, String email, String siape) {
        super(id, nome, cpf, dataNascimento, endereco, telefone, email);
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }
    public void setSiape(String siape) {
        this.siape = siape;
    }
}
