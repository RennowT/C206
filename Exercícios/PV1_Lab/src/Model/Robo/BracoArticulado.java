package Model.Robo;

import Model.Acessorios.Camera;
import Model.Acessorios.Garra;

public class BracoArticulado extends Robo{
    private int numeroDeArticulacoes;
    private Garra garra;
    private Camera camera = null;

    public BracoArticulado(String nome, int energiaMaxima, int numeroDeArticulacoes, Garra garra) {
        super(nome, energiaMaxima);
        this.numeroDeArticulacoes = numeroDeArticulacoes;
        this.garra = garra;
    }

    @Override
    public void trabalhar() {
        if (camera != null) {
            int pecasEncontradas = camera.acharPecas();
            for (int i = 0; i < pecasEncontradas; i++) {
                if (energia > 0) {
                    garra.agarrarPeca(i);
                    energia--;
                }
            }
        } else {
            System.out.println("Não há câmera!");
        }
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
