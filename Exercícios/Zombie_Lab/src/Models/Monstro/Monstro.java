package Models.Monstro;

public class Monstro {
    private int idade;
    protected int vida;
    protected int energia;

    public Monstro(int idade, int vida, int energia) {
        this.idade = idade;
        this.vida = vida;
        this.energia = energia;
    }

    public void assustar(Monstro monstroAlvo) {
        System.out.println("BUUUUU!!!");
    }

    public void tomaDano(int dano) {
        if (vida >= 0) {
            vida -= dano;
        } else {
            System.out.println("Monstro já está morto!");
        }
    }
}
