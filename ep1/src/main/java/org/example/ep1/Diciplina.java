package org.example.ep1;



public class Diciplina {
    private String nome;
    private String codigo;
    private int carga;
    private String[] requisitos;

    public Diciplina(String nome, String codigo, int carga, String[] requisitos){
        this.carga = carga;
        this.codigo = codigo;
        this.nome = nome;
        this.requisitos = requisitos;
    }

    public String getNome(){
        return nome;
    }
    public String getCodigo(){
        return codigo;
    }


}
