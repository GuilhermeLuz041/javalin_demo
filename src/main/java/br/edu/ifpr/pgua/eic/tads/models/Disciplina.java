package br.edu.ifpr.pgua.eic.tads.models;


public class Disciplina {
    private int id;
    private String nome;
    private String ementa;
    private int cargaHoraria;
    private Professor professor; 

    public Disciplina() {}

    public Disciplina(String nome, String ementa, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    



}
