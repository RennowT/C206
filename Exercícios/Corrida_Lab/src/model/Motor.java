package model;

public class Motor {
    private int potencia;
    private boolean torbo;

    public Motor(int potencia, boolean torbo) {
        this.potencia = potencia;
        this.torbo = torbo;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "\n\t\t\tpotencia=" + potencia +
                ",\n\t\t\ttorbo=" + torbo +
                "\n\t\t}";
    }
}
