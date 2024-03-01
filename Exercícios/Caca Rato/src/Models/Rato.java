package Models;

public class Rato {
    private int velocidade = 10;
    private boolean escondido = false;

    public void esconder() {
        this.escondido = true;
    }

    public void procurarComida() {
        this.escondido = false;
    }

    @Override
    public String toString() {
        return "Rato{" +
                "velocidade=" + velocidade +
                ", escondido=" + escondido +
                '}';
    }

    public int getVelocidade() {
        return velocidade;
    }

    public boolean isEscondido() {
        return escondido;
    }
}
