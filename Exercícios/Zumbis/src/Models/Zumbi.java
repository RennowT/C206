package Models;

public class Zumbi {
    private String nome;
    private int idade;
    private double vida;

    public Zumbi(String nome, int idade, double vida) {
        this.nome = nome;
        this.idade = idade;
        this.vida = vida;
    }

    public void emitirSomEstranho() {
        System.out.println(nome + " emite um som estranho: *grooaan*");
    }

    public void andarCambaleando() {
        System.out.println(nome + " anda cambaleando...");
    }

    public void perderVida(double quantidade) {
        this.vida -= quantidade;
        System.out.println(nome + " perdeu " + quantidade + " pontos de vida. Vida restante: " + vida);
    }

    public void exibirStatus() {
        System.out.println("Status de " + nome + ":");
        System.out.println("Idade: " + idade);
        System.out.println("Vida: " + vida);
    }
}

