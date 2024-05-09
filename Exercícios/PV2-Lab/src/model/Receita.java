package model;

public class Receita {
    private String nome;
    private int dificuldade;

    public Receita(String nome, int dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Receita{" +
                "nome='" + nome + '\'' +
                ", dificuldade=" + dificuldade +
                '}';
    }
}
