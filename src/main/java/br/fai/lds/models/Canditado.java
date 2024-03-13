package br.fai.lds.models;

public class Canditado {
    private int id;
    private String nome;
    private int numeroDeVotos;

    public Canditado(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void adicionarVoto(){
        numeroDeVotos+=1;
    }

    public int getNumeroDeVotos(){
        return numeroDeVotos;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
