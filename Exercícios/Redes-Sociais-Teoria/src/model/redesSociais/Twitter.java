package model.redesSociais;

import exceptions.CheckedException;

public class Twitter extends RedeSocial implements Compartilhamento{
    @Override
    public void compartilhar() throws CheckedException {
        System.out.println("Compartilhando publicação no Twitter");
    }

    @Override
    public void postarFoto() throws CheckedException {
        System.out.println("Postando foto no Twitter");
    }

    @Override
    public void postarVideo() throws CheckedException {
        System.out.println("Postando video no Twitter");
    }

    @Override
    public void postarComentario() throws CheckedException {
        System.out.println("Postando comentario no Twitter");
    }
}
