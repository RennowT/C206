package Models.Produtos;

public class Notebook extends Produto {
    private String processador;
    private String memoria;

    public Notebook(double valor, String nome, String processador, String memoria) {
        super(valor, nome);
        this.processador = processador;
        this.memoria = memoria;
    }

    public void instalarAplicativos() {
        System.out.println("Instalando aplicativos!");
    }

    @Override
    public void mostraInfo () {
        System.out.println("O notebook tem o processador " + processador + " e a memória " + memoria + "!");
    }
}
