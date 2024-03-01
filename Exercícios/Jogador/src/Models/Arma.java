package Models;

public class Arma {
    private String nome;
    private int dano;
    private int custoDeEnergia;

    public Arma(String nome, int dano, int custoDeEnergia) {
        this.nome = nome;
        this.dano = dano;
        this.custoDeEnergia = custoDeEnergia;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getCustoDeEnergia() {
        return custoDeEnergia;
    }
}
