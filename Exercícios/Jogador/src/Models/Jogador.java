package Models;

public class Jogador {
    private Arma arma;
    private int energia;
    private int vida;
    private String nome;

    public Jogador() {}

    public Jogador(Arma arma, int energia, int vida, String nome) {
        this.arma = arma;
        this.energia = energia;
        this.vida = vida;
        this.nome = nome;
    }

    public void atacar(Jogador alvo) {
        if (this.energia > this.arma.getCustoDeEnergia()) {
            alvo.sofreDano(this.arma.getDano());
            this.energia -= this.arma.getCustoDeEnergia();
        }
    }

    private void sofreDano(int dano) {
        if (this.vida > 0) {
            this.vida -= dano;
        }
    }

    @Override
    public String toString() {
        return "O jogador " + this.nome + " tem a arma " + this.arma.getNome() + ", " + this.energia + " de energia e " + this.vida + " de vida";
    }

}
