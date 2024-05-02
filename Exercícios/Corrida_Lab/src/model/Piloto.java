package model;

public class Piloto {
    private String nome;
    private int idade;
    private String nacionalidade;
    private int idGeral;
    private int id;

    public Piloto(String nome, int idade, String nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
    }

    public void correr(Carro carro) {
        System.out.println("O piloto " + nome + " está correndo com o carro " + carro);
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "\n\t\tnome='" + nome + '\'' +
                ",\n\t\tidade=" + idade +
                ",\n\t\tnacionalidade='" + nacionalidade + '\'' +
                ",\n\t\tidGeral=" + idGeral +
                ",\n\t\tid=" + id +
                "\n\t}";
    }
}
