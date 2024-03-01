package Models;

public class Gato {
    private String cor;
    private int idade;
    private int velocidade;

    public Gato(String cor, int idade, int velocidade) {
        this.cor = cor;
        this.idade = idade;
        this.velocidade = velocidade;
    }

    public void brincar() {
        System.out.println("Brincando");
    }

    public void caçar(Rato rato) {
        if (!rato.isEscondido() && this.velocidade > rato.getVelocidade()) {
            System.out.println("Caça bem sucedida!");
        } else {
            System.out.println("Caça mal sucedida!");
        }

    }

    @Override
    public String toString() {
        return "Gato{" +
                "cor='" + cor + '\'' +
                ", idade=" + idade +
                ", velocidade=" + velocidade +
                '}';
    }
}
