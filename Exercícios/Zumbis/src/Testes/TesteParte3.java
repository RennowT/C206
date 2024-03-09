package Testes;

import Models.Zumbi;

public class TesteParte3 {
    public static void main(String[] args) {
        // Criando dois zumbis
        Zumbi z1 = new Zumbi("Zé", 50, 100);
        Zumbi z2 = new Zumbi("Zeca", 40, 80);

        // Manipulando a vida individualmente
        z1.perderVida(30);
        z2.perderVida(20);

        // Exibindo a vida dos zumbis individualmente
        System.out.println("Vida de " + z1.getNome() + ": " + z1.getVida());
        System.out.println("Vida de " + z2.getNome() + ": " + z2.getVida());

        // Igualando as referências dos zumbis
        z1 = z2;

        // Manipulando a vida dos zumbis através de z1 e z2
        z1.recebeVida(20);
        z2.perderVida(10);

        // Exibindo a vida dos zumbis após manipulação
        System.out.println("\nApós manipular a vida dos zumbis através de z1 e z2:");
        System.out.println("Vida de " + z1.getNome() + ": " + z1.getVida());
        System.out.println("Vida de " + z2.getNome() + ": " + z2.getVida());
    }
}
