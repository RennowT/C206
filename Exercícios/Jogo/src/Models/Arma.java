package Models;

public class Arma {
    private String nome;
    private int poder;
    private int resistencia;
    private String descricao;

    public Arma(String nome, int poder, int resistencia, String descricao) {
        this.nome = nome;
        this.poder = poder;
        this.resistencia = resistencia;
        this.descricao = descricao;
    }

    public String mostrarInfoArma() {
        return "Arma{" +
                "nome='" + nome + '\'' +
                ", poder=" + poder +
                ", resistencia=" + resistencia +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public void reduzResistencia(int valor) {
        resistencia -= valor;
    }

    public int getPoder() {
        return poder;
    }
}
