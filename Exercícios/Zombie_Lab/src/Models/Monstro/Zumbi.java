package Models.Monstro;

public class Zumbi extends Monstro implements Mordida {
    private int numeroDeCerebrosComidos;

    public Zumbi(int idade, int vida, int energia, int numeroDeCerebrosComidos) {
        super(idade, vida, energia);
        this.numeroDeCerebrosComidos = numeroDeCerebrosComidos;
    }

    @Override
    public void atacarComMordida(Monstro monstroAlvo) {
        if (energia > 2) {
            monstroAlvo.tomaDano(5);
        } else {
            System.out.println("Energia insuficiente!");
        }
    }
}
