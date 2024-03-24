package models.computador.hardwareBasico;

public class HD extends HardwareBasico{

    public HD(String nome, int capacidade) {
        super(nome, capacidade);
    }

    @Override
    public String mostraInfo() {
        return converterParaTb(super.getCapacidade()) + " de " + super.getNome();
    }

    private String converterParaTb(int gb) {
        if (gb >= 1000) return (gb / 1000) + "Tb";
        return gb + "Gb";
    }
}
