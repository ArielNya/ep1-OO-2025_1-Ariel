package org.example.ep1;

public class Aluno {
    private String name;
    private String curso;
    private String matricula;

    public Aluno(String nome, String curso, String matricula){
        this.name = nome;
        this.curso = curso;
        this.matricula = matricula;
    }


    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public String getName() {
        return name;
    }


}
