import Models.Produtos.Console;
import Models.Produtos.Notebook;
import Models.Produtos.Produto;

public class Main {
    public static void main(String[] args) {
        // Testando a classe Produto
        Produto produto = new Produto(1000.0, "Produto Genérico");
        produto.mostraInfo();

        // Testando a classe Notebook
        Notebook notebook = new Notebook(2000.0, "Notebook XYZ", "Intel i7", "16GB");
        notebook.mostraInfo();
        notebook.instalarAplicativos();

        // Testando a classe Console
        Console console = new Console(1500.0, "Console ABC", "Xbox One", "Microsoft");
        console.mostraInfo();
        console.jogar();
    }
}