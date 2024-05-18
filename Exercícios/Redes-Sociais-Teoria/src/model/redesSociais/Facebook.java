package model.redesSociais;

import exceptions.CheckedException;

public class Facebook extends RedeSocial implements VideoConferencia, Compartilhamento{
    @Override
    public void postarFoto() throws CheckedException {
        System.out.println("Postando foto no Facebook");
    }

    @Override
    public void postarVideo() throws CheckedException {
        System.out.println("Postando video no Facebook");
    }

    @Override
    public void postarComentario() throws CheckedException {
        System.out.println("Postando comentario no Facebook");
    }

    @Override
    public void fazStreaming() throws CheckedException {
        System.out.println("Fazendo streaming no Facebook");
    }

    @Override
    public void compartilhar() throws CheckedException {
        System.out.println("Compartilhando publicação no Facebook");
    }
}
