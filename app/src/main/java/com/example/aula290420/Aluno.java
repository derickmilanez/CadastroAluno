package com.example.aula290420;

import java.io.Serializable;

public class Aluno implements Serializable {
    private String ra;
    private String nome;
    private String curso;

    public Aluno(String ra, String nome, String curso) {
        this.ra = ra;
        this.nome = nome;
        this.curso = curso;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString(){
        return nome;
    }

    public String getDados(){
        return "RA: " + ra + "\nNOME: " + nome + "\nCURSO: " + curso;
    }
}
