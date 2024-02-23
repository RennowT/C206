# Zé do Lanche App

## Descrição
O aplicativo "Zé do Lanche" permite que o usuário registre a quantidade de hambúrgueres consumidos em um determinado período e fornece informações como o número total de hambúrgueres consumidos e a média de hambúrgueres por registro.

## Como Usar
1. Execute o aplicativo.
2. Insira a quantidade de hambúrgueres consumidos quando solicitado.
3. O aplicativo calculará o número total de hambúrgueres consumidos e a média.

## Funcionalidades
- Registra a quantidade de hambúrgueres consumidos.
- Calcula o número total de hambúrgueres consumidos.
- Calcula a média de hambúrgueres consumidos.

## Exemplo de Uso
```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] consumedBurgers = new int[3];
        
        for (int i = 0; i < consumedBurgers.length; i++) {
            System.out.println("Digite a quantidade de hambúrgueres consumidos no registro " + (i + 1) + ": ");
            consumedBurgers[i] = scanner.nextInt();
        }

        scanner.close();

        int sumOfBurgersConsumed = 0;

        for (int i : consumedBurgers) {
            sumOfBurgersConsumed += i;
        }

        System.out.println("O número total de hambúrgueres consumidos foi de " + sumOfBurgersConsumed);

        float averageBurgerConsumed = (float) sumOfBurgersConsumed / consumedBurgers.length;
        System.out.println("A média de hambúrgueres consumidos foi de " + averageBurgerConsumed);
    }
}
