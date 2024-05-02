package model;

import java.util.Arrays;

public class Equipe {
    private Carro carro;
    private Piloto[] pilotos;
    private Piloto pilotoAtual;
    private String nome;

    private boolean trocarPilotoAtual(int pilotoId) {
        if (pilotos[pilotoId] == null) {
            return false;
        }

        pilotoAtual = pilotos[pilotoId];
        return true;
    }

    private boolean trocarPneu(int tipoDePneu) {
        if (carro == null) {
            return false;
        }

        carro.setTipoDePeneu(tipoDePneu);
        return true;
    }

    public void pitStop(int tipoDePneum, int pilotoId) {
        if (trocarPilotoAtual(pilotoId)) {
            System.out.println("Piloto trocado.");
        } else {
            System.out.println("Não foi possivel trocar o piloto.");
        }

        if (trocarPneu(tipoDePneum)) {
            System.out.println("Pneu trocado.");
        } else {
            System.out.println("Naõ foi possivel trocar o pneu.");
        }
    }

    public boolean adicionarPiloto(Piloto piloto) {
        for (int i = 0; i < pilotos.length; i++) {
            if (pilotos[i] == null) {
                pilotos[i] = piloto;
                return true;
            }
        }

        return false;
    }

    public boolean retirarPiloto(int pilotoId) {
        if (pilotos[pilotoId] == null) {
            return false;
        }

        pilotos[pilotoId] = null;
        return true;
    }

    public Equipe(String nome) {
        this.nome = nome;
        pilotos = new Piloto[4];
    }

    public void constroiCarro(int tipoDePneu, int potencia, boolean turbo) {
        if (carro == null) {
            carro = new Carro(tipoDePneu, potencia, turbo);
            System.out.println("Carro construido.");
            return;
        }

        System.out.println("Carro já foi construido.");
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "\n\tcarro=" + carro +
                ",\n\tpilotos=" + Arrays.toString(pilotos) +
                ",\n\tpilotoAtual=" + pilotoAtual +
                ",\n\tnome='" + nome + '\'' +
                "\n}";
    }
}
