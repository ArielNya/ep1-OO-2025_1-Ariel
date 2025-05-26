package org.example.ep1;

public class Aluno {
    private String name;
    private String curso;
    private int matricula;

    public Aluno(String nome, String curso, int matricula){
        this.name = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public String getName() {
        return name;
    }

    
}
