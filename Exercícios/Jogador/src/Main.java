import Models.Arma;
import Models.Jogador;

public class Main {
    public static void main(String[] args) {
        Arma espada = new Arma("espada", 5, 3);

        Jogador jogador1 = new Jogador(espada, 10, 20, "Clebinho");
        System.out.println(jogador1.toString());

        Jogador jogador2 = new Jogador(espada, 2, 10, "Joãozinho");
        System.out.println(jogador2.toString());

        jogador1.atacar(jogador2);
        System.out.println(jogador1.toString());
        System.out.println(jogador2.toString());
    }
}