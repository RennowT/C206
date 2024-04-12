package Model.Robo;

import Model.Pacote;

public class Empilhador extends Robo{
    private Pacote[] pacotes;
    private int pesoMaximo;

    public Empilhador(String nome, int energiaMaxima, int pesoMaximo) {
        super(nome, energiaMaxima);
        this.pesoMaximo = pesoMaximo;
        pacotes = new Pacote[10];
    }

    public void adicionarPacote(int peso) {
        int pesoAtual = 0;
        for (Pacote pacote : pacotes) {
            if (pacote != null) {
                pesoAtual += pacote.getPeso();
            }
        }

        if (pesoAtual + peso < pesoMaximo) {
            for (int i = 0; i < pacotes.length; i++) {
                if (pacotes[i] == null) {
                    pacotes[i] = new Pacote(peso);
                    return;
                }
            }
        }  else {
            System.out.println("Peso máximo atingido! Não é possível adicionar esse pacote!");
        }

    }

    public void removerPacote(int posicao) {
        if (posicao >= 0 && posicao < pacotes.length) {
            pacotes[posicao] = null;
        }
    }

    public void mostrarPacotes() {
        for (Pacote pacote : pacotes) {
            if (pacote != null) {
                System.out.println(pacote.toString());
            }
        }
    }
}
