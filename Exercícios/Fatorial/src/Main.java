import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        System.out.println(calcularFatorial(numero));
        printaNumeroPar(numero);
    }

    private static void printaNumeroPar(int numero) {
        for (int i = 1; i <= numero; i++)
            if(i % 2 == 0) {
                System.out.print(i + " ");
            }
    }

    // Método recursivo para calcular o fatorial
    public static int calcularFatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calcularFatorial(n - 1);
        }
    }

}