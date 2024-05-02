import model.Equipe;
import model.Piloto;

public class Main {
    public static void main(String[] args) {
        // Criando alguns pilotos
        Piloto piloto1 = new Piloto("Lewis Hamilton", 36, "Reino Unido");
        Piloto piloto2 = new Piloto("Max Verstappen", 24, "Holanda");

        // Criando uma equipe
        Equipe equipe = new Equipe("Equipe A");

        // Adicionando pilotos à equipe
        equipe.adicionarPiloto(piloto1);
        equipe.adicionarPiloto(piloto2);

        // Construindo o carro da equipe
        equipe.constroiCarro(3, 1000, true);

        // Realizando um pit stop
        equipe.pitStop(4, 0); // Trocar piloto atual e pneu

        // Testando a remoção de um piloto da equipe
        equipe.retirarPiloto(1); // Remover piloto2

        // Imprimindo informações da equipe após as operações
        System.out.println(equipe);
    }
}
