import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        int secretNumber = random.nextInt(10) + 1;

        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            int number = scanner.nextInt();

            if (number == secretNumber) {
                guessedCorrectly = true;
            } else {
                System.out.println("Você errou!");
                if (number < secretNumber) {
                    System.out.println("O número secreto é maior!");
                } else {
                    System.out.println("O número secreto é menor");
                }
            }
        }

        System.out.println("Você acertou!");
        scanner.close();
    }
}
