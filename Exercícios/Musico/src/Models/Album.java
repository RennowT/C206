package Models;

public class Album {
    private String nome;
    private int nota;

    public Album(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                '}';
    }
}
