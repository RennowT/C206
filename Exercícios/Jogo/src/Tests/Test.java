package Tests;

import Models.Arma;
import Models.Personagem;

public class Test {
    public static void main(String[] args) {
        // Criando uma arma
        Arma espada = new Arma("Espada", 10, 20, "Uma espada afiada.");

        // Criando dois personagens
        Personagem guerreiro = new Personagem("Guerreiro", 100, espada, 100);
        Personagem inimigo = new Personagem("Inimigo", 80, null, 80);

        // Usando a arma do guerreiro contra o inimigo
        guerreiro.usarArma(inimigo);

        // Exibindo informações do inimigo após o ataque
        System.out.println("Após ser atacado pelo guerreiro:");
        System.out.println("Vida do inimigo: " + inimigo.getVida());

        // Exibindo informações da arma após o uso
        System.out.println("Informações da arma após o uso:");
        System.out.println(espada.mostrarInfoArma());
    }
}
