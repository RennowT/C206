package models;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Item> itensArray = new ArrayList<>();

    public void adicionarArray(Item item) {
        itensArray.add(item);
    }

    public void buscar(int posicao) {
        if (posicao >= 0 && posicao < itensArray.size()) {
            String item = itensArray.get(posicao).toString();
            System.out.println(item);
        }
    }

    public void deletar(int posicao) {
        if (posicao >= 0 && posicao < itensArray.size()) {
            itensArray.remove(posicao);
        }
    }

    public void deletar(Item item) {
        itensArray.remove(item);
    }

    public void modificar(Item item, int posicao) {
        if (posicao >= 0 && posicao < itensArray.size()) {
            itensArray.set(posicao, item);
        }
    }

    public ArrayList<Item> getItensArray() {
        return itensArray;
    }
}
