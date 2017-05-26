package com.example.jeancarlos.snapfootball.Model;

import java.io.Serializable;

/**
 * Created by Jean Carlos on 26/05/2017.
 */

public class Usuario implements Serializable {

    private Long id_usuario;
    private String username;
    private String email;
    private String senha;

    public Long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
