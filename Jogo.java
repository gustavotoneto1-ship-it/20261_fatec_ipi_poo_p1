import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        Personagem p1 = new Personagem();
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
            System.out.println("******************");
            Thread.sleep(5000);
        }
        while (p1.getEnergia() > 0);
        System.out.printf("Personagem %s morreu, mochila: %s", p1.nome, p1.getMochila());
    }
}
