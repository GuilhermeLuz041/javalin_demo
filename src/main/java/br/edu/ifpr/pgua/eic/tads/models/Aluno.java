package br.edu.ifpr.pgua.eic.tads.models;

import java.time.LocalDate;

public class Aluno extends Pessoa {

    private String matricula;

    public Aluno() {
    }

    public Aluno(int id, String nome, String cpf, LocalDate dataNascimento, String endereco,
                String telefone, String email, String matricula) {
        super(id, nome, cpf, dataNascimento, endereco, telefone, email);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
