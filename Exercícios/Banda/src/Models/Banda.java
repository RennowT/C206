package Models;

public class Banda {
    private Musica[] musicas = new Musica[10];
    private String nome;
    private int numeroDeIntegrantes;

    public Banda(String nome, int numeroDeIntegrantes) {
        this.nome = nome;
        this.numeroDeIntegrantes = numeroDeIntegrantes;
    }

    public void tocarMusica(int posicao) {
        if (musicas[posicao] != null) {
            System.out.println("Tocando Música!");
            return;
        }
        System.out.println("Não há musica nessa posição!");
    }

    public void tocarShow() {
        System.out.println("Tocando show!");
    }

    public boolean adicionarMusica(Musica musica) {
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] == null) {
                musicas[i] = musica;
                return true;
            }
        }
        return false;
    }

    public boolean deletarMusica(String nome) {
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i].getNome().equals(nome)) {
                musicas[i] = null;
                return true;
            }
        }
        return false;
    }
}
