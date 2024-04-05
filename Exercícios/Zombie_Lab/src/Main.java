import Models.Monstro.Bruxa;
import Models.Monstro.Monstro;
import Models.Monstro.Vampiro;
import Models.Monstro.Zumbi;

public class Main {
    public static void main(String[] args) {
        // Criando instâncias das classes Monstro
        Monstro monstro1 = new Monstro(50, 100, 80);
        Zumbi zumbi1 = new Zumbi(30, 80, 60, 10);
        Vampiro vampiro1 = new Vampiro(100, 150, 100, 20, false);
        Bruxa bruxa1 = new Bruxa(200, 120, 90);

        // Testando métodos das instâncias
        monstro1.assustar(zumbi1);
        zumbi1.atacarComMordida(vampiro1);
        vampiro1.transformar();
        bruxa1.aprenderFeitico("Expelliarmus", 15);
        bruxa1.lancarFeitico(monstro1, 0);
    }
}
