import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        Personagem p1 = new Personagem("Gustavo");

        Personagem p2 = new Personagem("Tico Trovador", 4, 8, 8);
        p2.getRepertorio().add(new Musica("No One Noticed"));

        ArrayList<Musica> disponiveis = new ArrayList<>();

        disponiveis.add(new Musica("Evidencias"));
        disponiveis.add(new Musica("Sinonimos"));
        disponiveis.add(new Musica("Abracadabra"));
        disponiveis.add(new Musica("Infiel"));
        disponiveis.add(new Musica("Voando pro Para"));
        disponiveis.add(new Musica("S de Saudade"));
        disponiveis.add(new Musica("A Lua me traiu"));
        disponiveis.add(new Musica("Dacing Queen"));
        disponiveis.add(new Musica("Mamma Mia"));
        disponiveis.add(new Musica("Fico Assim Sem Voce"));

        Random gerador = new Random();
        int cont = 0;
        do {
            int oQueFazer = gerador.nextInt(1, 4);
            if (p1.getEnergia() > 0) {
                switch (oQueFazer) {
                    case 1:
                        p1.cacar();
                        System.out.println(p1);
                        break;
                    case 2:
                        p1.comer();
                        System.out.println(p1);
                        break;
                    case 3:
                        p1.dormir();
                        System.out.println(p1);
                        break;
                }
                p1.aprenderMusica(disponiveis);
            }

            if (p2.getEnergia() > 0) {
                System.out.printf("-------------------\n");
                int oQueFazer2 = gerador.nextInt(1, 10);
                switch (oQueFazer2) {
                    case 1, 2:
                        p2.cacar();
                        System.out.println(p2);
                        break;
                    case 3, 4:
                        p2.comer();
                        System.out.println(p2);
                        break;
                    case 5, 6, 7, 8, 9, 10:
                        p2.dormir();
                        System.out.println(p2);
                        break;
                }
            p2.aprenderMusica(disponiveis);
            }
            if (p1.getEnergia() > 0 && p2.getEnergia() > 0) {
                System.out.printf("-------------------\n");
                System.out.printf("Duelo Musical:\n");
                int QuemDuela = gerador.nextInt(1, 3);
                switch (QuemDuela) {
                    case 1:
                        var EscolheMusica1 = gerador.nextInt(p1.getRepertorio().size());
                        if (p1.getRepertorio().isEmpty()) 
                        break;
                        Musica musica1 = p1.getRepertorio().get(EscolheMusica1);
                        System.out.printf("%s duela\n", p1.nome);
                        System.out.printf("Musica: %s\n", musica1.getTitulo());
                        if (p2.getRepertorio().contains(musica1)) {
                            System.out.printf("Adversário já conhece\n");
                            p1.setEnergia(p1.getEnergia() - 1);
                            p2.setEnergia(p2.getEnergia() - 1);
                        } else {
                            System.out.printf("Adversário não conhece\n");
                            p2.setEnergia(p2.getEnergia() - 1);
                            p2.getRepertorio().add(musica1);
                        }
                        break;
                    case 2:
                        var EscolheMusica2 = gerador.nextInt(p2.getRepertorio().size());
                        if (p2.getRepertorio().isEmpty()) 
                        break;
                        Musica musica2 = p2.getRepertorio().get(EscolheMusica2);
                        System.out.printf("%s duela\n", p2.nome);
                        System.out.printf("Musica: %s\n", musica2.getTitulo());
                        if (p1.getRepertorio().contains(musica2)) {
                            System.out.printf("Adversário já conhece\n");
                            p1.setEnergia(p1.getEnergia() - 1);
                            p2.setEnergia(p2.getEnergia() - 1);
                        } else {
                            System.out.printf("Adversário não conhece\n");
                            p1.setEnergia(p1.getEnergia() - 1);
                            p1.getRepertorio().add(musica2);
                        }
                        break;
                }
            }
            if (p1.getEnergia() == 0 && cont == 0) {
                System.out.printf("O personagem %s morreu mochila:%s, %s campeão do duelo\n", p1.nome, p1.getMochila(), p2.nome);
                cont = cont + 1;
            } 
            if (p2.getEnergia() == 0 && cont == 0) {
                System.out.printf("O personagem %s morreu mochila:%s, %s campeão do duelo\n", p2.nome, p2.getMochila(), p1.nome);
                cont = cont + 1;
            }

            System.out.printf("******************\n");
            Thread.sleep(5000);

        }
        while (p1.getEnergia() > 0 || p2.getEnergia() > 0);
        System.out.printf("Os personages %s e %s morreram, possuiam as respectivas mochilas: %s e %s", p1.nome, p2.nome, p1.getMochila(), p2.getMochila());
    }
}
