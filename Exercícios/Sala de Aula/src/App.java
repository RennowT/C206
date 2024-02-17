import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudentsEnrolled = scanner.nextInt();

        scanner.close();

        switch (numberOfStudentsEnrolled) {
            case 10:
            case 20:
                System.out.println("Sala I-16");
                break;
            case 30:
                System.out.println("Sala I-22");
                break;
            default:
                System.out.println("Naõ sera na sala I-16, nem na I-22");
                break;
        }
    }
}
