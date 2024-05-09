package model.pirata;

import model.Receita;

import java.util.ArrayList;

public class Cozinheiro extends Pirata{
    private ArrayList<Receita> livroDeReceitas = new ArrayList();

    public Cozinheiro(String nome, String comidaFavorita, int poder, ArrayList<Receita> livroDeReceitas) {
        super(nome, comidaFavorita, poder);
        this.livroDeReceitas = livroDeReceitas;
    }

    public String prepararPrato(int index) {
        try {
            return livroDeReceitas.get(index).getNome();
        } catch (Exception e) {
            System.out.println("Erro ao preparar prato");
            return null;
        }
    }

    public void mostrarReceita() {
        try {
            for (Receita receita : livroDeReceitas) {
                System.out.println(receita.toString());
            }
        } catch (NullPointerException e) {
            System.out.println("Erro ao mostrar Receita");
        }
    }
}
