package Models;

public class Empresario {
    private String nome;
    private String cnpj;

    public Empresario(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }
}
