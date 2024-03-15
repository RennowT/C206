package Models;

import java.util.Arrays;

public class Musico {
    private Album[] albuns = new Album[10];
    private String nome;

    public Musico(String nome) {
        this.nome = nome;
    }

    public void listar() {
        String lista = "Musico{" +
                "albums=" + Arrays.toString(albuns) +
                ", nome='" + nome + '\'' +
                '}';

        System.out.println(lista);
    }

    public void adicionar(Album novoAlbum) {
        for (int i = 0; i < albuns.length; i++) {
            if (albuns[i] == null) {
                albuns[i] = novoAlbum;
                return;
            }
        }
    }

    public void deletar(int posicao) {
        albuns[posicao] = null;
    }
}
