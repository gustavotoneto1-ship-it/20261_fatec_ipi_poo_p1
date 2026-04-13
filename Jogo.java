import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        Personagem p1 = new Personagem("Gustavo");

        Personagem p2 = new Personagem("Tico Trovador", 3, 8, 8);
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
        
            System.out.println("******************");;
            if (p2.getEnergia() > 0) {
                int oQueFazer2 = gerador.nextInt(1, 10);
                switch (oQueFazer2) {
                    case 1:
                    case 2:
                        p2.cacar();
                        System.out.println(p2);
                        break;
                    case 3:
                    case 4:
                        p2.comer();
                        System.out.println(p2);
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        p2.dormir();
                        System.out.println(p2);
                        break;
                }
            p2.aprenderMusica(disponiveis);
            }
         
            System.out.println("******************");
            Thread.sleep(5000);

        }
        while (p1.getEnergia() > 0 || p2.getEnergia() > 0);
        System.out.printf("Os personages %s e %s morreram, possuiam as respectivas mochilas: %s e %s", p1.nome, p2.nome, p1.getMochila(), p2.getMochila(), p2.getMochila());
    }
}
