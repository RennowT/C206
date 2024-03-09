package Models;

public class Calculadora {
    private static double pi = Math.PI;

    public static double circulferencia(double raio) {
        return 2 * pi * raio;
    }

    public static double volumeEsfera(double raio) {
        return (4 * pi * Math.pow(raio, 3)) / 3;
    }

    public static double volumeCilindro(double raio, double altura) {
        return pi * Math.pow(raio, 2) * altura;
    }

}