package br.fai.lds;

import br.fai.lds.models.Canditado;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Map<Integer, Canditado> mapaDeCandidatos = new HashMap<>();


    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    private void start() {
        inicializarMapaDeCanditados();
        while(true){
            int voto = obterVoto();
            if(voto == 0){
                break;
            }
            registrarVoto(voto);
        }


    }

    private void registrarVoto(int voto) {
        if(!mapaDeCandidatos.containsKey(voto)){
            System.out.println("Candidato inexistente. Tente novamente ");
            return;
        }
        Canditado canditado = mapaDeCandidatos.get(voto);
        canditado.adicionarVoto();
    }

    private int obterVoto() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite seu voto: ");
            int voto = scanner.nextInt();
            return voto;
        }catch (Exception e){
            scanner.next();
            System.out.println("Voto invalido");
            return -1;

        }

    }

    private void inicializarMapaDeCanditados() {
        Canditado joao = new Canditado(1,"Joao");
//        joao.setId(1);joao.setNome("Joao");

        Canditado maria = new Canditado(2,"Maria");
        Canditado jose = new Canditado(3,"Jose");
        Canditado antonio = new Canditado(4,"Antonio");
        Canditado tiburssinho = new Canditado(5,"Tiburssinho");
//        maria.setId(2);maria.setNome("Maria");
        mapaDeCandidatos.put(joao.getId(), joao);
        mapaDeCandidatos.put(maria.getId(),maria);
        mapaDeCandidatos.put(jose.getId(),jose);
        mapaDeCandidatos.put(antonio.getId(),antonio);
        mapaDeCandidatos.put(tiburssinho.getId(),tiburssinho);
    }
}
