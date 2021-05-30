package com.jornada.microsservico.seguranca.domain;

public class Livro {

    private int id;
    private String nome;
    private String autor;

    public Livro() {
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro {" +
                "id=" + id +
                ", nome ='" + nome + '\'' +
                ", autor ='" + autor + '\'' +
                '}';
    }
}
