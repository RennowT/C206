package model.redesSociais;

import exceptions.CheckedException;

public abstract class RedeSocial {
    protected String senha;
    protected int numAmigos;

    public abstract void postarFoto() throws CheckedException;

    public abstract void postarVideo() throws CheckedException;

    public abstract void postarComentario() throws CheckedException;

    public void curtirPublicacao() throws CheckedException{
        System.out.println("Curtindo publicação");
    }
}
