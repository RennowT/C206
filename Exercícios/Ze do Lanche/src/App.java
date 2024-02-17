import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] consumedBurgers = new int[3];
        
        for (int i = 0; i < consumedBurgers.length; i++) {
            consumedBurgers[i] = scanner.nextInt();
        }

        scanner.close();

        int sumOfBurguersConsumed = 0;

        for (int i : consumedBurgers) {
            sumOfBurguersConsumed += i;
        }

        System.out.println("O número de lanches consumidos foi de " + sumOfBurguersConsumed);

        float averageBurgerConsumed = sumOfBurguersConsumed / consumedBurgers.length;
        System.out.println("A média de lanches consumidos foi de " + averageBurgerConsumed);
    }
}
