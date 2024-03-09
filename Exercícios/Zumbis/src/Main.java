import Models.Zumbi;

public class Main {
    public static void main(String[] args) {
        // Criando um zumbi
        Zumbi zumbi1 = new Zumbi("Zé", 50, 100);

        // Realizando ações do zumbi
        System.out.println("Ações do zumbi:");
        zumbi1.emitirSomEstranho();
        zumbi1.andarCambaleando();
        zumbi1.perderVida(30);
        zumbi1.exibirStatus();
    }
}