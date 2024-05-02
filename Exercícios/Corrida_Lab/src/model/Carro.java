package model;

public class Carro {
    private Motor motor;
    private int tipoDePeneu;

    public Carro(int tipoDePeneu, int potencia, boolean turbo) {
        this.motor = new Motor(potencia, turbo);
        this.tipoDePeneu = tipoDePeneu;
    }

    public void setTipoDePeneu(int tipoDePeneu) {
        this.tipoDePeneu = tipoDePeneu;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "\n\t\tmotor=" + motor +
                ",\n\t\ttipoDePeneu=" + tipoDePeneu +
                "\n\t}";
    }
}
