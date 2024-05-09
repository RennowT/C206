package main;

import model.Receita;
import model.pirata.Capitao;
import model.pirata.Cozinheiro;
import model.pirata.Espadachim;
import model.pirata.Pirata;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Espadachim esp = new Espadachim("Espadachim", "Bacon",5, "Espada");
        esp.darOrdens();
        esp.mudarRota();

        Capitao cap = new Capitao("Capitão", "Macarrão", 7, 0);
        cap.darOrdens();
        cap.mudarRota();
        cap.conquistarNovoSeguidor(esp);

        ArrayList<Receita> listaDeReceitas = new ArrayList<Receita>();
        listaDeReceitas.add(new Receita("Macarrão", 3));
        listaDeReceitas.add(new Receita("Bacon", 1));
        listaDeReceitas.add(new Receita("Salmão na manteiga", 8));

        Cozinheiro coz = new Cozinheiro("Cozinheiro", "Salmão na manteiga", 3, listaDeReceitas);
        coz.mostrarReceita();
        coz.comer(coz, 2);

        System.out.println(esp.toString());
        System.out.println(cap.toString());
        System.out.println(coz.toString());

        Pirata pirata = coz.lutar(esp);
        System.out.println("O vencedor foi " + pirata.getNome());
    }
}