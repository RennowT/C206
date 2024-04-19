package Main;

import Model.Atleta.Ciclista;
import Model.Atleta.Corredor;
import Model.Atleta.Nadador;

public class Main {
    public static void main(String[] args) {
        Nadador nadador = new Nadador();
        Corredor corredor  = new Corredor();
        Ciclista ciclista = new Ciclista();

        nadador.treinar();

        corredor.colocarEquipamento();
        corredor.treinar();

        ciclista.colocarEquipamento();
        ciclista.treinar();
    }
}