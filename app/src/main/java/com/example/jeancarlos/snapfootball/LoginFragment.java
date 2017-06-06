package com.example.jeancarlos.snapfootball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeancarlos.snapfootball.DAO.UsuarioDAO;


public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        return v;

    }

    public void verificacaoUsuario (View v) {
       /* UsuarioDAO userDAO = new UsuarioDAO(this.getContext());

        EditText txtUser = (EditText) v.findViewById(R.id.etUsernameLogin);
        EditText txtSenha = (EditText) v.findViewById(R.id.etSenhaLogin);

        // TRIM - REMOVE ESPAÇO EM BRANCO DAS STRINGS, NO COMEÇO E FIM
        if (txtSenha.getText().toString().trim().equals("") || txtUser.getText().toString().trim().equals("")){

            Toast.makeText(getContext(), "Digite algum valor nos campos!", Toast.LENGTH_LONG).show();

        } else  {
            boolean acesso = userDAO.(txtUser.getText().toString().trim(), txtSenha.getText().toString().trim());

            UserDAO.usuario = txtUser.getText().toString();

            if (acesso) {
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);

                this.finish();
            } else {
                Toast.makeText(getApplicationContext(), "Usuário e/ou senha incorretos!", Toast.LENGTH_LONG).show();
            }
        } */

    }


}
