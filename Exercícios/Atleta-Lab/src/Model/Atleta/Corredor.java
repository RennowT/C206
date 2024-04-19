package Model.Atleta;

import Model.Equipamento;

public class Corredor extends Atleta implements Equipamento {
    @Override
    public void treinar() {
        System.out.println("Treinando corredor...");
    }

    @Override
    public void colocarEquipamento() {
        System.out.println("Colocando equipamento de corredor...");
    }
}
