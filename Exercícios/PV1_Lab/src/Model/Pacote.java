package Model;

public class Pacote {
    private int peso;

    public Pacote(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "O pacote tem " + peso + " de peso!";
    }
}
