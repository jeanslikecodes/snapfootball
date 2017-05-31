package com.example.jeancarlos.snapfootball.Helper;

import android.view.View;
import android.widget.EditText;

import com.example.jeancarlos.snapfootball.Model.Usuario;
import com.example.jeancarlos.snapfootball.R;

/**
 * Created by Jean Carlos on 31/05/2017.
 */

public class UsuarioHelper {

    private EditText etUsername, etEmail, etSenha;
    private Usuario usuario;

    public UsuarioHelper(View view) {
        this.etUsername = (EditText) view.findViewById(R.id.editUsername);
        this.etEmail = (EditText) view.findViewById(R.id.editEmail);
        this.etSenha = (EditText) view.findViewById(R.id.editSenha);
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        usuario.setUsername(etUsername.getText().toString());
        usuario.setEmail(etEmail.getText().toString());
        usuario.setSenha(etSenha.getText().toString());
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        etUsername.setText(usuario.getUsername());
        etEmail.setText(usuario.getEmail());
        etSenha.setText(usuario.getSenha());
        this.usuario = usuario;
    }


}
