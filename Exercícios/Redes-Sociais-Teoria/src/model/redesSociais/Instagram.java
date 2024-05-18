package model.redesSociais;

import exceptions.CheckedException;

public class Instagram extends RedeSocial{
    @Override
    public void postarFoto() throws CheckedException {
        System.out.println("Postando foto no Instagram");
    }

    @Override
    public void postarVideo() throws CheckedException {
        System.out.println("Postando video no Instagram");
    }

    @Override
    public void postarComentario() throws CheckedException {
        System.out.println("Postando comentario no Instagram");
    }
}
