import Models.Banda;
import Models.Empresario;
import Models.Membro;
import Models.Musica;

public class Main {
    public static void main(String[] args) {
        // Criando membros da banda
        Membro membro1 = new Membro("Membro 1", "Vocalista");
        Membro membro2 = new Membro("Membro 2", "Guitarrista");
        Membro membro3 = new Membro("Membro 3", "Baixista");

        // Criando empresário
        Empresario empresario = new Empresario("Empresário", "123456789");

        // Criando músicas
        Musica musica1 = new Musica("Música 1", 4.5);
        Musica musica2 = new Musica("Música 2", 3.7);

        // Criando banda
        Banda banda = new Banda("Banda A", "Rock");

        // Definindo empresário da banda
        banda.setEmpresario(empresario);

        // Adicionando membros à banda
        banda.addMembroNovo(membro1);
        banda.addMembroNovo(membro2);
        banda.addMembroNovo(membro3);

        // Adicionando músicas à banda
        banda.addMusicaNova(musica1);
        banda.addMusicaNova(musica2);

        // Mostrando informações da banda
        banda.mostrarInfo();
    }
}
