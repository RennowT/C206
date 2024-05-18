package main;

import exceptions.UncheckedException;
import model.Usuario;
import model.redesSociais.*;

public class Main {
    public static void main(String[] args) {
        Facebook facebook = new Facebook();
        GooglePlus googlePlus = new GooglePlus();
        Twitter twitter = new Twitter();
        Instagram instagram = new Instagram();

        RedeSocial[] redeSocials = { facebook, googlePlus };
        Usuario usuario = new Usuario(redeSocials);

        try {
            for (RedeSocial redeSocial : usuario.getRedesSociais()) {
                if (redeSocial instanceof Facebook) {
                    redeSocial.postarFoto();
                    redeSocial.postarVideo();
                    ((Facebook) redeSocial).compartilhar();
                } else if (redeSocial instanceof GooglePlus) {
                    redeSocial.postarComentario();
                    redeSocial.curtirPublicacao();
                    ((GooglePlus) redeSocial).fazStreaming();
                } else if (redeSocial instanceof Twitter) {
                    redeSocial.postarFoto();
                    redeSocial.postarComentario();
                    ((Twitter) redeSocial).compartilhar();
                } else if (redeSocial instanceof Instagram) {
                    redeSocial.postarVideo();
                    redeSocial.curtirPublicacao();
                    redeSocial.postarComentario();
                }
            }
        } catch (UncheckedException e) {
            System.out.println("UncheckedException capturada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Outra exceção capturada: " + e.getMessage());
        }
    }
}