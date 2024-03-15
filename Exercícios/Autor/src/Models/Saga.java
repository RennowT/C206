package Models;

import java.util.Arrays;

public class Saga {
    private int nota;
    private Livro[] livros = new Livro[10];

    public Saga(int nota) {
        this.nota = nota;
    }

    public void listarLivros() {
        System.out.println(
                "Saga{" + "livros=" + Arrays.toString(livros) + '}'
        );
    }

    public void adicionarLivro(Livro livro) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                livros[i] = livro;
                return;
            }
        }
    }
}
