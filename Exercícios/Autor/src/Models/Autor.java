package Models;

import java.util.Arrays;

public class Autor {
    private String nome;
    private Saga[] sagas = new Saga[10];

    public Autor(String nome) {
        this.nome = nome;
    }

    public void listarSagas() {
        for (Saga saga : sagas) {
            if (saga != null) {
                saga.listarLivros();
            }
        }
    }

    public void adicionarSaga(Saga saga) {
        for (int i = 0; i < sagas.length; i++) {
            if (sagas[i] == null) {
                sagas[i] = saga;
                return;
            }
        }
    }
}
