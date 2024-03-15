import Models.Autor;
import Models.Livro;
import Models.Saga;

public class Main {
    public static void main(String[] args) {
        // Criando alguns livros
        Livro livro1 = new Livro("Livro 1", 200);
        Livro livro2 = new Livro("Livro 2", 300);
        Livro livro3 = new Livro("Livro 3", 250);

        // Criando algumas sagas
        Saga saga1 = new Saga(8);
        Saga saga2 = new Saga(9);
        Saga saga3 = new Saga(7);

        // Adicionando livros às sagas
        saga1.adicionarLivro(livro1);
        saga1.adicionarLivro(livro2);
        saga2.adicionarLivro(livro3);

        // Criando um autor
        Autor autor = new Autor("Autor");

        // Adicionando sagas ao autor
        autor.adicionarSaga(saga1);
        autor.adicionarSaga(saga2);
        autor.adicionarSaga(saga3);

        // Listando as sagas do autor
        System.out.println("Sagas do autor:");
        autor.listarSagas();

        // Listando os livros de uma das sagas
        System.out.println("Livros da primeira saga:");
        saga1.listarLivros();
    }
}
