package Model.Atleta;

import Model.Equipamento;

public class Ciclista extends Atleta implements Equipamento {
    @Override
    public void treinar() {
        System.out.println("Treinando ciclista...");
    }

    @Override
    public void colocarEquipamento() {
        System.out.println("Colocando equipamento de ciclista...");
    }
}
