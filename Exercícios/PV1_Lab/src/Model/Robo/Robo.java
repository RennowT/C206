package Model.Robo;

public class Robo {
    protected int energia;
    private String nome;
    private static int totalDeRobos = 0;
    private int energiaMaxima;

    public Robo(String nome, int energiaMaxima) {
        this.nome = nome;
        this.energiaMaxima = energiaMaxima;
        this.energia = energiaMaxima;
        totalDeRobos++;
    }

    public void trabalhar() {
        System.out.println("Trabalhando");
        this.energia--;
    }

    public void trocarEnergia(Robo roboAlvo) {
       final int valorNecessarioRoboAlvo = roboAlvo.getEnergiaMaxima() - roboAlvo.getEnergia();
       final int valorMaximoRobo = energia - 1;
       if (valorNecessarioRoboAlvo > valorMaximoRobo) {
           energia -= valorMaximoRobo;
           roboAlvo.recarregar(valorMaximoRobo);
       } else {
           energia -= valorNecessarioRoboAlvo;
           roboAlvo.recarregar(valorNecessarioRoboAlvo);
       }
    }

    public void recarregar(int horas) {
        if (energia + horas <= energiaMaxima) {
            energia += horas;
        } else if (energia + horas > energiaMaxima) {
            energia = energiaMaxima;
        }
    }

    public int getEnergia() {
        return energia;
    }

    public int getEnergiaMaxima() {
        return energiaMaxima;
    }
}
