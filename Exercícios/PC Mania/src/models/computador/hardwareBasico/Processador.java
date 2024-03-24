package models.computador.hardwareBasico;

public class Processador extends HardwareBasico{
    public Processador(String nome, int capacidade) {
        super(nome, capacidade);
    }

    @Override
    public String mostraInfo() {
        return super.getNome() + " (" + super.getCapacidade() + " Mhz)";
    }
}
