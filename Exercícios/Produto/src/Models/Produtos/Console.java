package Models.Produtos;

public class Console extends Produto{
    private String geracao;
    private String marca;

    public Console(double valor, String nome, String geracao, String marca) {
        super(valor, nome);
        this.geracao = geracao;
        this.marca = marca;
    }

    public void jogar() {
        System.out.println("Jogando!");
    }

    @Override
    public void mostraInfo() {
        System.out.println("O console da " + marca + " é de " + geracao + " geração!");
    }
}
