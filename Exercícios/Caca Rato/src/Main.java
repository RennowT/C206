import Models.Gato;
import Models.Rato;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato("Laranja", 3, 15);
        Rato rato = new Rato();

        System.out.println(gato.toString());
        System.out.println(rato.toString());

        rato.esconder();

        gato.brincar();
        gato.caçar(rato);

        rato.procurarComida();
        gato.caçar(rato);
    }
}