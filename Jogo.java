import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        Personagem p1 = new Personagem("Gustavo");

        ArrayList<Musica> disponiveis = new ArrayList<>();

        disponiveis.add(new Musica("Evidencias"));
        disponiveis.add(new Musica("Sinonimos"));
        disponiveis.add(new Musica("Abracadabra"));
        disponiveis.add(new Musica("Infiel"));
        disponiveis.add(new Musica("Voando pro Pará"));
        disponiveis.add(new Musica("S de Saudade"));
        disponiveis.add(new Musica("A Lua me traiu"));
        disponiveis.add(new Musica("Dacing Queen"));
        disponiveis.add(new Musica("Mamma Mia"));
        disponiveis.add(new Musica("Fico Assim Sem Voce"));

        do {
            Random gerador = new Random();
            int oQueFazer = gerador.nextInt(1, 4);
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
            System.out.println("******************");
            Thread.sleep(5000);
        }
        while (p1.getEnergia() > 0);
        System.out.printf("Personagem %s morreu, mochila: %s", p1.nome, p1.getMochila());
    }
}
