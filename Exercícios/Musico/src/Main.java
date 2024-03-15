import Models.*;

public class Main {
    public static void main(String[] args) {
        // Criando alguns álbuns
        Album album1 = new Album("Álbum 1", 8);
        Album album2 = new Album("Álbum 2", 9);
        Album album3 = new Album("Álbum 3", 7);

        // Criando um músico
        Musico musico = new Musico("Músico");

        // Adicionando álbuns ao músico
        musico.adicionar(album1);
        musico.adicionar(album2);
        musico.adicionar(album3);

        // Listando os álbuns do músico
        System.out.println("Álbuns do músico:");
        musico.listar();

        // Deletando um álbum
        musico.deletar(1); // Deleta o álbum na posição 1

        // Listando os álbuns atualizados do músico
        System.out.println("Álbuns do músico após deletar:");
        musico.listar();
    }
}
