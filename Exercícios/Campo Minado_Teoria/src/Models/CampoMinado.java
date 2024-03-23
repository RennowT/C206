package Models;

import java.util.Random;
import java.util.Scanner;

public class CampoMinado {
    private int tamanho;
    private int numeroDeMinas;
    private char[][] tabuleiro;
    private boolean[][] minas;

    public CampoMinado(int tamanho, int numeroDeMinas) {
        this.tamanho = tamanho;
        this.numeroDeMinas = numeroDeMinas;
        tabuleiro = new char[tamanho][tamanho];
        minas = new boolean[tamanho][tamanho];
        inicializarTabuleiro();
        colocarMinas();
    }

    private void colocarMinas() {
        Random rand = new Random();
        int count = 0;
        while (count < numeroDeMinas) {
            int x = rand.nextInt(tamanho);
            int y = rand.nextInt(tamanho);
            if (!minas[x][y]) {
                minas[x][y] = true;
                count++;
            }
        }
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                tabuleiro[i][j] = '-';
                minas[i][j] = false;
            }
        }
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            imprimirTabuleiro();
            System.out.print("Digite a linha: ");
            int linha = scanner.nextInt();
            System.out.print("Digite a coluna: ");
            int coluna = scanner.nextInt();

            if (minas[linha][coluna]) {
                System.out.println("Você perdeu!");
                tabuleiro[linha][coluna] = '*';
                imprimirTabuleiro();
                break;
            } else if (!minas[linha][coluna]) {
                tabuleiro[linha][coluna] = '+';
            }

            if (venceu()) {
                System.out.println("Você venceu!");
                imprimirTabuleiro();
                break;
            }
        }
        scanner.close();
    }

    private boolean venceu() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (!minas[i][j] && tabuleiro[i][j] != '+') {
                    return false;
                }
            }
        }
        return true;
    }

    private void imprimirTabuleiro() {
        System.out.print("  ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tamanho; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
