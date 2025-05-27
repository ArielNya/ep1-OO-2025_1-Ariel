package org.example.ep1;

public class Aluno implements DisplayableEntity {
    private final String id;
    private final String nome;
    private final String curso;

    public Aluno(String id, String nome, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }

    @Override
    public String getDisplayText() {
        return id + " - " + nome;
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
}