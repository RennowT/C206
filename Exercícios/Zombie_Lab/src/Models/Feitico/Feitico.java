package Models.Feitico;

public class Feitico {
    private String nome;
    private int poder;

    public Feitico(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "O feitiço " + nome + " tem " + poder + " de poder";
    }

    public int getPoder() {
        return poder;
    }
}
