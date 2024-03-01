package Model;

import java.util.Scanner;

public class Aluno {
    private int matricula;
    private int np1;
    private int np2;
    private int periodo;
    private String nome;

    public Aluno(int matricula, int np1, int np2, int periodo, String nome) {
        this.matricula = matricula;
        this.np1 = np1;
        this.np2 = np2;
        this.periodo = periodo;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "O aluno " + this.nome + ", matricula " + this.matricula + ", do " + this.periodo + "º periodo teve uma média final de " + calcularMedia();
    }

    private int calcularMedia() {
        int media = (np1 + np2) / 2;
        if (media > 60) {
            return media;
        }
        return calculaNP3(media);
    }

    private static int calculaNP3(int media) {
        System.out.print("A média não foi suficiente. Insira o valor da NP3: ");
        Scanner scanner = new Scanner(System.in);
        int np3 = scanner.nextInt();
        return (np3 + media) / 2;
    }

}
