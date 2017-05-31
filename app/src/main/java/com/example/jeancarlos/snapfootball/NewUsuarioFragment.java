package com.example.jeancarlos.snapfootball;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jeancarlos.snapfootball.DAO.UsuarioDAO;
import com.example.jeancarlos.snapfootball.Helper.UsuarioHelper;
import com.example.jeancarlos.snapfootball.Model.Usuario;


public class NewUsuarioFragment extends Fragment {

    UsuarioHelper helper;

    public NewUsuarioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_usuario, container, false);


        helper = new UsuarioHelper(v);

        Intent intent = getActivity().getIntent();
        final Usuario usuario = (Usuario) intent.getSerializableExtra("goNewUsuario");
        final EditText senha = (EditText) v.findViewById(R.id.editSenha);
        final EditText senha2 = (EditText) v.findViewById(R.id.editSenha2);


        Button btnSave = (Button) v.findViewById(R.id.btnCriarConta);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario newUsuario = helper.getUsuario();
                UsuarioDAO dao = new UsuarioDAO(getActivity());

                if (senha2.getText().toString().equals(senha.getText().toString())) {
                    dao.insertUsuario(newUsuario);
                    dao.close();

                    Toast.makeText(getActivity(), "Usuário " + newUsuario.getUsername() + " cadastrado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "As senhas não conicidem", Toast.LENGTH_LONG).show();
                }

                getActivity().finish();
            }
        });


        return v;
    }


}
