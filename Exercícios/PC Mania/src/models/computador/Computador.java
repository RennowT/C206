package models.computador;

import models.computador.hardwareBasico.HardwareBasico;

public class Computador {
    private String marca;
    private float valor;
    private HardwareBasico[] hardware = new HardwareBasico[3];
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca,
                      float valor,
                      HardwareBasico[] hardware,
                      SistemaOperacional sistemaOperacional,
                      MemoriaUSB memoriaUSB
    ) {
        this.marca = marca;
        this.valor = valor;
        this.hardware = hardware;
        this.sistemaOperacional = sistemaOperacional;
        this.memoriaUSB = memoriaUSB;
    }

    public String mostraPCConfigs() {
        String textoHardwareBasico = "";

        for (int i = 0; i < hardware.length; i++) {
            textoHardwareBasico += hardware[i].mostraInfo() + "\n";
        }

        String configuracao = "Marca: " + marca +
                "\nPreço: R$" + formatarValor(valor) +
                "\n" + textoHardwareBasico +
                "Sistema Operacional " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)" +
                "\nAcompanha " + memoriaUSB.getNome() + " de " + converterParaTb(memoriaUSB.getCapacidade()) + "\n";

        return configuracao;
    }

    private static String formatarValor(double valor) {
        return String.format("%.2f", valor);
    }

    private String converterParaTb(int gb) {
        if (gb >= 1000) return (gb / 1000) + "Tb";
        return gb + "Gb";
    }

    public float getValor() {
        return valor;
    }
}
