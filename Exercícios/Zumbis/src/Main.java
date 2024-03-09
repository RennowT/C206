import Models.Zumbi;

public class Main {
    public static void main(String[] args) {
        // Criando zumbis
        Zumbi zumbi1 = new Zumbi("Zé", 50, 100);
        Zumbi zumbi2 = new Zumbi("Zeca", 40, 80);

        // Testando todos os métodos da classe Zumbi
        System.out.println("Testando todos os métodos da classe Zumbi:");

        // Emitir som estranho e andar cambaleando
        zumbi1.emitirSomEstranho();
        zumbi1.andarCambaleando();
        zumbi2.emitirSomEstranho();
        zumbi2.andarCambaleando();

        // Perder vida
        zumbi1.perderVida(30);
        zumbi2.perderVida(20);

        // Exibir status
        zumbi1.exibirStatus();
        zumbi2.exibirStatus();

        // Testando os métodos adicionais: getVida(), getNome(), recebeVida() e transfereVida()
        System.out.println("\nTestando métodos adicionais da classe Zumbi:");

        // getVida() e getNome()
        System.out.println("Vida de " + zumbi1.getNome() + ": " + zumbi1.getVida());
        System.out.println("Vida de " + zumbi2.getNome() + ": " + zumbi2.getVida());

        // recebeVida()
        zumbi1.recebeVida(20);
        zumbi2.recebeVida(10);
        System.out.println("Após receber vida:");
        System.out.println("Vida de " + zumbi1.getNome() + ": " + zumbi1.getVida());
        System.out.println("Vida de " + zumbi2.getNome() + ": " + zumbi2.getVida());

        // transfereVida()
        zumbi1.transfereVida(zumbi2, 30);
        System.out.println("Após transferir vida:");
        System.out.println("Vida de " + zumbi1.getNome() + ": " + zumbi1.getVida());
        System.out.println("Vida de " + zumbi2.getNome() + ": " + zumbi2.getVida());
    }
}
