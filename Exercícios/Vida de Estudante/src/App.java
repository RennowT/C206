import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int PV1 = scanner.nextInt();
        int PV2 = scanner.nextInt();
        int LE = scanner.nextInt();

        int NP1 = (int) Math.round(0.6 * PV1 + 0.4 * LE);
        int NP2 = (int) Math.round(0.6 * PV2 + 0.4 * LE);

        int NPA = (int) Math.round((NP1 + NP2) / 2);
        
        if (NPA >= 60) {
            System.out.println("Aprovado. Nota: " + NPA);
            return;
        } else if(NPA >=30 && NPA <= 60) {
            System.out.println("Vai fazer NP3. Nota: " + NPA);

            int NP3 = scanner.nextInt();
            if((NPA + NP3) / 2 >= 50) {
                System.out.println("Aprovado");
            } else {
                System.out.println("Reprovado");
            }
        } else {
            System.out.println("Reprovado. Nota: " + NPA);
        }

        scanner.close();
    }
}
