package Models.Monstro;

import Models.Feitico.Feitico;

public class Bruxa extends Monstro{
    private Feitico[] listaFeiticos;

    public Bruxa(int idade, int vida, int energia) {
        super(idade, vida, energia);
        this.listaFeiticos = new Feitico[100];
    }

    public boolean aprenderFeitico(String nome, int poder) {
        for (int i = 0; i < listaFeiticos.length; i++) {
            if (listaFeiticos[i] == null) {
                listaFeiticos[i] = new Feitico(nome, poder);
                return true;
            }
        }
        return false;
    }

    public void listarFeiticos() {
        for (Feitico feitico : listaFeiticos) {
            if (feitico != null) {
                System.out.println(feitico);
            }
        }
    }

    public void esquecerFeitico(int posicao) {
        if (listaFeiticos[posicao] != null) {
            listaFeiticos[posicao] = null;
            System.out.println("Feitiço esquecido!");
        } else {
            System.out.println("Não há nenhum feitiço aprendido nesta posição!");
        }
    }

    public void lancarFeitico(Monstro monstroAlvo, int posicao) {
        if (energia > 5) {
            monstroAlvo.tomaDano(listaFeiticos[posicao].getPoder());
        } else {
            System.out.println("Eneergia insuficiente!");
        }
    }
}
