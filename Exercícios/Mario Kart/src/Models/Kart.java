package Models;

public class Kart {
    private String nome;
    private Piloto piloto;
    private Motor motor;

    public Kart(String nome, Piloto piloto, Motor motor) {
        this.nome = nome;
        this.piloto = piloto;
        this.motor = motor;
    }

    public void pular() {
        System.out.println("Pulando!");
    }

    public void soltarTurbo() {
        System.out.println("Liberando Turbo!");
    }

    public void fazerDrift() {
        System.out.println("Fazendo Drift!");
    }
}
