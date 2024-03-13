package br.fai.lds.models;

public class Canditado {
    private int id;
    private String nome;

    public Canditado(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
