package Models;

public class Personagem {
    private String nome;
    private int pontos;
    private Arma arma;
    private double vida;

    public Personagem(String nome, int pontos, Arma arma, double vida) {
        this.nome = nome;
        this.pontos = pontos;
        this.arma = arma;
        this.vida = vida;
    }

    public void tomarDano(int dano) {
        vida -= dano;
    }

    public void usarArma(Personagem personagemAtacado) {
        personagemAtacado.tomarDano(5);
        arma.reduzResistencia(2);
    }

    public double getVida() {
        return vida;
    }
}
