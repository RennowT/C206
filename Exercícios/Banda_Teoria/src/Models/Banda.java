package Models;

public class Banda {
    private String nome;
    private String genero;
    private Empresario empresario;
    private Membro[] membros = new Membro[10];
    private Musica[] musicas = new Musica[10];

    public Banda(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public void mostrarInfo() {
        System.out.println("Informações da banda " + nome + ":");
        System.out.println("Gênero: " + genero);
        System.out.println("Empresário: " + empresario.getNome());

        System.out.println("Membros:");
        for (Membro membro : membros) {
            if (membro != null) {
                System.out.println("- " + membro.getNome() + " (" + membro.getFuncao() + ")");
            }
        }

        System.out.println("Músicas:");
        for (Musica musica : musicas) {
            if (musica != null) {
                System.out.println("- " + musica.getNome() + " (" + musica.getDuracao() + ")");
            }
        }
    }

    public boolean addMusicaNova(Musica musica) {
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] == null) {
                musicas[i] = musica;
                return true;
            }
        }

        return false;
    }

    public boolean addMembroNovo(Membro membro) {
        for (int i = 0; i < membros.length; i++) {
            if (membros[i] == null) {
                membros[i] = membro;
                return true;
            }
        }

        return false;
    }

    public void setEmpresario(Empresario empresario) {
        this.empresario = empresario;
    }
}
