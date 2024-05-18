package model.redesSociais;

import exceptions.CheckedException;

public class GooglePlus extends RedeSocial implements VideoConferencia, Compartilhamento{
    @Override
    public void postarFoto() throws CheckedException {
        System.out.println("Postando foto no Google Plus");
    }

    @Override
    public void postarVideo() throws CheckedException {
        System.out.println("Postando video no Google Plus");
    }

    @Override
    public void postarComentario() throws CheckedException {
        System.out.println("Postando comentario no Google Plus");
    }

    @Override
    public void fazStreaming() throws CheckedException {
        System.out.println("Fazendo streaming no Google Plus");
    }

    @Override
    public void compartilhar() throws CheckedException {
        System.out.println("Compartilhando publicação no Google Plus");
    }
}
