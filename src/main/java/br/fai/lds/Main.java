package br.fai.lds;

import br.fai.lds.models.Canditado;

import java.util.*;

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
        apurarVotos();


    }

    private void apurarVotos() {
        List<Canditado>canditados = new ArrayList<>();

        for (Canditado canditado:mapaDeCandidatos.values()){
            canditados.add(canditado);
        }
        //faz ordenação da lista
        canditados.sort((a,b)-> {
            return  b.getNumeroDeVotos() - a.getNumeroDeVotos();
        });

        Canditado canditadoEleito =  canditados.get(0);
        if(canditadoEleito.getNumeroDeVotos() == 0){
            System.out.println("Nenhum candidato foi votado.");
            return;
        }
        List<Canditado>candidatosEmpatados = new ArrayList<>();
        for (Canditado canditado:canditados){
            if(canditado.getId() == canditadoEleito.getId()){
                continue;
            }
            if(canditado.getNumeroDeVotos()== canditadoEleito.getNumeroDeVotos()){
                candidatosEmpatados.add(canditado);
            }
        }
        if(!candidatosEmpatados.isEmpty()){
            System.out.println("Ocorreu empate entre os candidatos. ");

            for (Canditado canditado:candidatosEmpatados){
                System.out.println("Candidatos empatados: " + canditado.getNome() + "com " + canditado.getNumeroDeVotos() + " votos");
            }

            return;
        }

        System.out.println("O candidato eleito é o " + canditadoEleito.getNome() + " com " + canditadoEleito.getNumeroDeVotos());

        for (int i = 0; i < canditados.size(); i++) {
            int ordemNumerica = i + 1;
            Canditado canditado = canditados.get(i);
            System.out.println("Lugar " + ordemNumerica + " Candidato " + canditado.getNome()+ " com "+ canditado.getNumeroDeVotos() + " votos");

        }
        return;
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
