package models.computador.hardwareBasico;

public class MemoriaRAM extends HardwareBasico{
    public MemoriaRAM(String nome, int capacidade) {
        super(nome, capacidade);
    }

    @Override
    public String mostraInfo() {
        return super.getCapacidade() + "Gb de " + super.getNome();
    }
}
