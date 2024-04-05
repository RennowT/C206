package Models.Monstro;

public class Vampiro extends Monstro implements Mordida {
    private int medidorDeSangue;
    private boolean formaDeMorcego = false;

    public Vampiro(
            int idade,
            int vida,
            int energia,
            int medidorDeSangue,
            boolean formaDeMorcego
    ) {
        super(idade, vida, energia);
        this.medidorDeSangue = medidorDeSangue;
        this.formaDeMorcego = formaDeMorcego;
    }

    public void transformar() {
        formaDeMorcego = !formaDeMorcego;
        if (formaDeMorcego) {
            System.out.println("Tranformou em morcego!");
        } else {
            System.out.println("Tranformou em humano!");
        }
    }

    public void recuperarVida() {
        if (energia > 5) {
            vida += medidorDeSangue;
        }
    }

    @Override
    public void atacarComMordida(Monstro monstroAlvo) {
        if (energia > 2) {
            monstroAlvo.tomaDano(5);
            medidorDeSangue += 2;
        } else {
            System.out.println("Energia insuficiente!");
        }
    }
}
