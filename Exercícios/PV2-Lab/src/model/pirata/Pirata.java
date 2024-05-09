package model.pirata;

public class Pirata {
    private String nome;
    private String comidaFavorita;
    protected int poder;

    public Pirata(String nome, String comidaFavorita, int poder) {
        this.nome = nome;
        this.comidaFavorita = comidaFavorita;
        this.poder = poder;
    }

    public void comer(Cozinheiro cozinheiro, int index) {
        String prato = cozinheiro.prepararPrato(index);
        if (prato == null) {
            return;
        } else if (prato.equals(comidaFavorita)) {
            poder += 2;
            return;
        }

        poder++;
    }

    public Pirata lutar(Pirata pirata) {
        if (pirata.getPoder() > this.poder) {
            return pirata;
        }

        return this;
    }

    public int getPoder() {
        return poder;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pirata{" +
                "nome='" + nome + '\'' +
                ", comidaFavorita='" + comidaFavorita + '\'' +
                ", poder=" + poder +
                '}';
    }
}
