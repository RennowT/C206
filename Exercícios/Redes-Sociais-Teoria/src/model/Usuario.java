package model;

import model.redesSociais.RedeSocial;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Usuario {
    private String nome;
    private String email;
    private Set<RedeSocial> redesSocias;

    public Usuario(RedeSocial[] redesSocias) {
        this.redesSocias = new HashSet<>();
        Collections.addAll(this.redesSocias, redesSocias);
    }

    public Set<RedeSocial> getRedesSociais() {
        return redesSocias;
    }
}
