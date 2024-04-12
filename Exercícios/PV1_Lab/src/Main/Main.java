package Main;

import Model.Acessorios.Camera;
import Model.Acessorios.Garra;
import Model.Robo.BracoArticulado;
import Model.Robo.Empilhador;

public class Main {
    public static void main(String[] args) {
        System.out.println("Braço Articulado:\n");

        Garra garra = new Garra(5);
        BracoArticulado bra1 = new BracoArticulado("bra1", 10, 3, garra);

        bra1.trabalhar();

        Camera camera = new Camera(5);
        bra1.setCamera(camera);
        bra1.trabalhar();

        System.out.println("\nEmpilhador:\n");

        Empilhador emp1 = new Empilhador("emp1", 10, 10);

        for (int i = 0; i < 5; i++) {
            emp1.adicionarPacote(3);
        }

        emp1.removerPacote(3);
        emp1.removerPacote(15);

        emp1.mostrarPacotes();

        System.out.println("\nClasse Robo:\n");

        bra1.trocarEnergia(emp1);
        bra1.recarregar(3);

        emp1.trabalhar();
        emp1.trocarEnergia(bra1);
        emp1.recarregar(1);
    }
}