package Models;

public class Motor {
    private String cilindradas;
    private static final float velocidadeMaxima = 150;

    public Motor(String cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "cilindradas='" + cilindradas + '\'' +
                '}';
    }
}
