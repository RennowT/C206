import Models.Banda;
import Models.Musica;

public class Main {
    public static void main(String[] args) {
        // Criando algumas músicas
        Musica musica1 = new Musica("Música 1", "Álbum 1");
        Musica musica2 = new Musica("Música 2", "Álbum 2");
        Musica musica3 = new Musica("Música 3", "Álbum 3");

        // Criando uma banda
        Banda banda = new Banda("Banda A", 4);

        // Adicionando músicas à banda
        banda.adicionarMusica(musica1);
        banda.adicionarMusica(musica2);
        banda.adicionarMusica(musica3);

        // Tocando uma música
        banda.tocarMusica(0); // Tocar a primeira música

        // Tocando o show
        banda.tocarShow();

        // Deletando uma música
        banda.deletarMusica("Música 2");

        // Tentando tocar a música deletada
        banda.tocarMusica(1); // Não há música nesta posição

        // Tentando tocar uma música inexistente
        banda.tocarMusica(1); // Não há música nesta posição
    }
}
