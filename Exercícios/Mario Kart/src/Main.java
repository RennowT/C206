import Models.Kart;
import Models.Motor;
import Models.Piloto;

public class Main {
    public static void main(String[] args) {
        // Criando um piloto
        Piloto piloto = new Piloto("Mario", false);

        // Criando um motor
        Motor motor = new Motor("150");

        // Criando um kart com o piloto e o motor
        Kart kart = new Kart("Speedy", piloto, motor);

        // Testando alguns métodos do kart
        System.out.println("Testando métodos do kart:");
        kart.pular();
        kart.soltarTurbo();
        kart.fazerDrift();

        // Testando o método soltaSuperPoder do piloto
        System.out.println("\nTestando método soltaSuperPoder do piloto:");
        piloto.soltaSuperPoder();

        // Exibindo informações do motor
        System.out.println("\nInformações do motor:");
        System.out.println(motor);
    }
}
